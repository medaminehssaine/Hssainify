package hssaine.mohammedamine.ensam.web;

import hssaine.mohammedamine.ensam.entities.Album;
import hssaine.mohammedamine.ensam.entities.Artiste;
import hssaine.mohammedamine.ensam.entities.Chanson;
import hssaine.mohammedamine.ensam.service.AlbumService;
import hssaine.mohammedamine.ensam.service.ArtisteService;
import hssaine.mohammedamine.ensam.service.ChansonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chansons")
public class ChansonController {

    @Autowired
    private ChansonService chansonService;

    @Autowired
    private ArtisteService artisteService;

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("chansons", chansonService.list());
        return "chanson/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("artistes", artisteService.list());
        model.addAttribute("albums", albumService.list());
        if (id != null) model.addAttribute("chanson", chansonService.get(id));
        return "chanson/add";
    }

    @PostMapping("/save")
    public String save(@RequestParam String titre,
                       @RequestParam(required = false) Integer duree,
                       @RequestParam(required = false) String genre,
                       @RequestParam(required = false) Long album,
                       @RequestParam(required = false) Long artiste,
                       @RequestParam(required = false) Long id,
                       org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {

        Chanson c = new Chanson();
        c.setTitre(titre);
        c.setDuree(duree);
        c.setGenre(genre);

        if (album != null) {
            Album al = albumService.get(album);
            c.setAlbum(al);
        }
        if (artiste != null) {
            Artiste ar = artisteService.get(artiste);
            c.setArtiste(ar);
        }

        if (id == null) {
            chansonService.ajouter(c);
            ra.addFlashAttribute("message", "Song created successfully.");
        } else {
            c.setId(id);
            chansonService.modifier(c);
            ra.addFlashAttribute("message", "Song updated successfully.");
        }

        return "redirect:/chansons";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        chansonService.supprimer(id);
        ra.addFlashAttribute("message", "Song deleted.");
        return "redirect:/chansons";
    }
}
