package ma.ensam.spring.service;

import ma.ensam.spring.entities.EtudiantModule;
import ma.ensam.spring.entities.EtudiantModuleKey;

import java.util.List;

public interface EtudiantModuleService {

    void ajouter(EtudiantModule em);
    void modifier(EtudiantModule em);
    void supprimer(EtudiantModuleKey id);
    EtudiantModule get(EtudiantModuleKey id);

    List<EtudiantModule> list();
}
