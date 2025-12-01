package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.entities.Album;
import java.util.List;

public interface AlbumService {
    void ajouter(Album a);
    void modifier(Album a);
    void supprimer(Long id);
    Album get(Long id);
    List<Album> list();
}
