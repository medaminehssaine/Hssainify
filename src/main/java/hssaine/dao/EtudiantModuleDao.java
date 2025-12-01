package ma.ensam.spring.dao;

import ma.ensam.spring.entities.EtudiantModule;
import ma.ensam.spring.entities.EtudiantModuleKey;

import java.util.List;

public interface EtudiantModuleDao {

    void add(EtudiantModule em);
    void update(EtudiantModule em);
    void delete(EtudiantModuleKey id);
    EtudiantModule find(EtudiantModuleKey id);

    List<EtudiantModule> findAll();
}
