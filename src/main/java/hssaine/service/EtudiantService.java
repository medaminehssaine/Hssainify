package ma.ensam.spring.service;

import ma.ensam.spring.entities.Etudiant;
import java.util.List;

public interface EtudiantService {
    void ajouter(Etudiant e);
    void modifier(Etudiant e);
    void supprimer(Long id);
    Etudiant get(Long id);
    List<Etudiant> list();
}
