package ma.ensam.spring.web;

import ma.ensam.spring.entities.Filiere;
import ma.ensam.spring.model.FiliereModel;
import ma.ensam.spring.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filiere")
public class FiliereController {

	@Autowired
	private FiliereService filiereService;

	// LISTE
	@GetMapping("/list")
	public String list(Model model) {
		FiliereModel m = new FiliereModel();
		m.setFilieres(filiereService.list());
		model.addAttribute("model", m);
		return "filiere/list";
	}

	// FORMULAIRE AJOUT
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("model", new FiliereModel());
		return "filiere/add";
	}

	// FORMULAIRE EDIT
	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		FiliereModel m = new FiliereModel();
		m.setFiliere(filiereService.get(id));
		model.addAttribute("model", m);
		return "filiere/edit";
	}

	// SUPPRESSION
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, Model model) {
		filiereService.supprimer(id);
		FiliereModel m = new FiliereModel();
		m.setFilieres(filiereService.list());
		m.setMessage("Filière supprimée avec succès.");
		model.addAttribute("model", m);
		return "filiere/list";
	}

	// AJOUT OU MODIFICATION
	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam String nom, Model model) {

		Filiere f = new Filiere();
		f.setNom(nom);

		FiliereModel m = new FiliereModel();

		if (id == null) {
			filiereService.ajouter(f);
			m.setMessage("Filière ajoutée avec succès.");
		} else {
			f.setId(id);
			filiereService.modifier(f);
			m.setMessage("Filière modifiée avec succès.");
		}

		m.setFilieres(filiereService.list());
		model.addAttribute("model", m);

		return "filiere/list";
	}
}
