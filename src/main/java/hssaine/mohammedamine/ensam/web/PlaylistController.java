package hssaine.mohammedamine.ensam.web;

import hssaine.mohammedamine.ensam.entities.Chanson;
import hssaine.mohammedamine.ensam.entities.Playlist;
import hssaine.mohammedamine.ensam.service.ChansonService;
import hssaine.mohammedamine.ensam.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private ChansonService chansonService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("playlists", playlistService.list());
        return "playlist/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, @RequestParam(required = false) Long id) {
        if (id != null) model.addAttribute("playlist", playlistService.get(id));
        return "playlist/add";
    }

    @PostMapping("/save")
    public String save(@RequestParam String nom,
                       @RequestParam(required = false) String description,
                       @RequestParam(required = false) Long id) {
        Playlist p = new Playlist();
        p.setNom(nom);
        p.setDescription(description);
        if (id == null) playlistService.ajouter(p);
        else { p.setId(id); playlistService.modifier(p); }
        return "redirect:/playlists";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam Long id) {
        Playlist p = playlistService.get(id);
        model.addAttribute("playlist", p);
        model.addAttribute("chansons", chansonService.list());
        return "playlist/view";
    }

    @PostMapping("/addSong")
    public String addSong(@RequestParam Long playlistId, @RequestParam Long chansonId, @RequestParam(required = false) Integer ordre, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        playlistService.addSongToPlaylist(playlistId, chansonId, ordre);
        ra.addFlashAttribute("message", "Song added to playlist.");
        return "redirect:/playlists/view?id=" + playlistId;
    }

    @GetMapping("/removeSong")
    public String removeSong(@RequestParam Long playlistId, @RequestParam Long chansonId, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        playlistService.removeSongFromPlaylist(playlistId, chansonId);
        ra.addFlashAttribute("message", "Song removed from playlist.");
        return "redirect:/playlists/view?id=" + playlistId;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
        playlistService.supprimer(id);
        ra.addFlashAttribute("message", "Playlist deleted.");
        return "redirect:/playlists";
    }
}
