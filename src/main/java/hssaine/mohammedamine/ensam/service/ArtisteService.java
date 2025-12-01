package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.entities.Artiste;
import java.util.List;

public interface ArtisteService {
    void ajouter(Artiste a);
    void modifier(Artiste a);
    void supprimer(Long id);
    Artiste get(Long id);
    List<Artiste> list();
}
