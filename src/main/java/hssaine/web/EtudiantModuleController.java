package ma.ensam.spring.web;

import ma.ensam.spring.entities.*;
import ma.ensam.spring.model.NoteModel;
import ma.ensam.spring.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class EtudiantModuleController {
	@Autowired
	private EtudiantModuleService etudiantModuleService;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private ModuleService moduleService;
	// ✔ FORMULAIRE D'AJOUT DE NOTE
	@GetMapping
	public String form(Model model) {
		NoteModel m = new NoteModel();
		m.setEtudiants(etudiantService.list());
		m.setModules(moduleService.list());
		model.addAttribute("model", m);
		return "note/add";
	}
	// ✔ TRAITEMENT FORMULAIRE
	@PostMapping("/save")
	public String save(@RequestParam Long etudiant, @RequestParam Long module, @RequestParam double note, Model model) {
		EtudiantModuleKey key = new EtudiantModuleKey(etudiant, module);
		EtudiantModule em = new EtudiantModule();
		em.setId(key);
		em.setEtudiant(etudiantService.get(etudiant));
		em.setModule(moduleService.get(module));
		em.setNote(note);
		etudiantModuleService.ajouter(em);
		NoteModel m = new NoteModel();
		m.setMessage("Note enregistrée avec succès.");
		m.setEtudiants(etudiantService.list());
		m.setModules(moduleService.list());
		model.addAttribute("model", m);
		return "note/add";
	}
}
