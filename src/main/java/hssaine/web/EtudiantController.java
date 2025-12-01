package ma.ensam.spring.web;

import ma.ensam.spring.entities.Etudiant;
import ma.ensam.spring.model.EtudiantModel;
import ma.ensam.spring.service.EtudiantService;
import ma.ensam.spring.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private FiliereService filiereService;

	@GetMapping
	public String list(Model model) {
		EtudiantModel m = new EtudiantModel();
		m.setEtudiants(etudiantService.list());
		model.addAttribute("model", m);
		return "etudiant/list";
	}

	@GetMapping("/add")
	public String addForm(Model model, @RequestParam(required = false) Long id) {
		EtudiantModel m = new EtudiantModel();
		m.setFilieres(filiereService.list());

		if (id != null) {
			// load existing student for editing
			Etudiant e = etudiantService.get(id);
			m.setEtudiant(e);
		}

		model.addAttribute("model", m);
		return "etudiant/add";
	}

	@PostMapping("/save")
	public String save(@RequestParam String nom, @RequestParam String prenom, @RequestParam Long filiere,
			@RequestParam(required = false) Long id) {

		Etudiant e = new Etudiant();
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setFiliere(filiereService.get(filiere));

		if (id == null) {
			etudiantService.ajouter(e);
		} else {
			e.setId(id);
			etudiantService.modifier(e);
		}

		return "redirect:/etudiants";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		etudiantService.supprimer(id);
		return "redirect:/etudiants";
	}
}
