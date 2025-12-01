package hssaine.mohammedamine.ensam.web;

import hssaine.mohammedamine.ensam.entities.Album;
import hssaine.mohammedamine.ensam.entities.Artiste;
import hssaine.mohammedamine.ensam.service.AlbumService;
import hssaine.mohammedamine.ensam.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtisteService artisteService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("albums", albumService.list());
        return "album/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("artistes", artisteService.list());
        if (id != null) {
            model.addAttribute("album", albumService.get(id));
        }
        return "album/add";
    }

    @PostMapping("/save")
    public String save(@RequestParam String titre,
                       @RequestParam(required = false) String dateSortie,
                       @RequestParam(required = false) Long artiste,
                       @RequestParam(required = false) Long id,
                       org.springframework.web.servlet.mvc.support.RedirectAttributes ra) throws Exception {

        Album a = new Album();
        a.setTitre(titre);
        if (dateSortie != null && !dateSortie.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(dateSortie);
            a.setDateSortie(d);
        }
        if (artiste != null) {
            Artiste art = artisteService.get(artiste);
            a.setArtiste(art);
        }

        if (id == null) {
            albumService.ajouter(a);
            ra.addFlashAttribute("message", "Album created successfully.");
        } else {
            a.setId(id);
            albumService.modifier(a);
            ra.addFlashAttribute("message", "Album updated successfully.");
        }

        return "redirect:/albums";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        albumService.supprimer(id);
        ra.addFlashAttribute("message", "Album deleted.");
        return "redirect:/albums";
    }
}
