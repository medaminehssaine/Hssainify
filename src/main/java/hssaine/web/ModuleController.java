package ma.ensam.spring.web;

import ma.ensam.spring.entities.Module;
import ma.ensam.spring.model.ModuleModel;
import ma.ensam.spring.service.ModuleService;
import ma.ensam.spring.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private FiliereService filiereService;
	// LISTE
	@GetMapping("/list")
	public String list(Model model) {
		ModuleModel m = new ModuleModel();
		m.setModules(moduleService.list());
		model.addAttribute("model", m);
		return "module/list";
	}
	// FORMULAIRE AJOUT
	@GetMapping("/add")
	public String add(Model model) {
		ModuleModel m = new ModuleModel();
		m.setFilieres(filiereService.list());
		model.addAttribute("model", m);
		return "module/add";
	}
	// FORMULAIRE EDIT
	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		ModuleModel m = new ModuleModel();
		m.setModule(moduleService.get(id));
		m.setFilieres(filiereService.list());
		model.addAttribute("model", m);
		return "module/edit";
	}

	// DELETE
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, Model model) {
		moduleService.supprimer(id);
		ModuleModel m = new ModuleModel();
		m.setModules(moduleService.list());
		m.setMessage("Module supprimé avec succès.");
		model.addAttribute("model", m);
		return "module/list";
	}
	// SAVE (ADD OU EDIT)
	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam String code,
			@RequestParam String intitule, @RequestParam Long filiere, Model model) {
		Module m = new Module();
		m.setCode(code);
		m.setIntitule(intitule);
		m.setFiliere(filiereService.get(filiere));
		ModuleModel view = new ModuleModel();
		if (id == null) {
			moduleService.ajouter(m);
			view.setMessage("Module ajouté avec succès.");
		} else {
			m.setId(id);
			moduleService.modifier(m);
			view.setMessage("Module modifié avec succès.");
		}
		view.setModules(moduleService.list());
		model.addAttribute("model", view);
		return "module/list";
	}
}
