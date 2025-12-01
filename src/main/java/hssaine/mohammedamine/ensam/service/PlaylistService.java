package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.entities.Playlist;
import java.util.List;

public interface PlaylistService {
    void ajouter(Playlist p);
    void modifier(Playlist p);
    void supprimer(Long id);
    Playlist get(Long id);
    List<Playlist> list();
    void addSongToPlaylist(Long playlistId, Long chansonId, Integer ordre);
    void removeSongFromPlaylist(Long playlistId, Long chansonId);
}
