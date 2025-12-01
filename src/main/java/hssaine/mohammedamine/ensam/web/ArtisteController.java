package hssaine.mohammedamine.ensam.web;

import hssaine.mohammedamine.ensam.entities.Artiste;
import hssaine.mohammedamine.ensam.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artistes")
public class ArtisteController {

    @Autowired
    private ArtisteService artisteService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("artistes", artisteService.list());
        return "artiste/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, @RequestParam(required = false) Long id) {
        if (id != null) {
            model.addAttribute("artiste", artisteService.get(id));
        }
        return "artiste/add";
    }

    @PostMapping("/save")
    public String save(@RequestParam String nom,
                       @RequestParam(required = false) String nationalite,
                       @RequestParam(required = false) Long id,
                       org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        Artiste a = new Artiste();
        a.setNom(nom);
        a.setNationalite(nationalite);
        if (id == null) {
            artisteService.ajouter(a);
            ra.addFlashAttribute("message", "Artist created successfully.");
        } else {
            a.setId(id);
            artisteService.modifier(a);
            ra.addFlashAttribute("message", "Artist updated successfully.");
        }
        return "redirect:/artistes";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        artisteService.supprimer(id);
        ra.addFlashAttribute("message", "Artist deleted.");
        return "redirect:/artistes";
    }
}
