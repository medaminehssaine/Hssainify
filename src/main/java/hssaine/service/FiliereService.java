package ma.ensam.spring.service;

import ma.ensam.spring.entities.Filiere;
import java.util.List;

public interface FiliereService {
    void ajouter(Filiere f);
    void modifier(Filiere f);
    void supprimer(Long id);
    Filiere get(Long id);
    List<Filiere> list();
}
