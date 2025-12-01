package ma.ensam.spring.service;

import ma.ensam.spring.entities.Module;
import java.util.List;

public interface ModuleService {
    void ajouter(Module m);
    void modifier(Module m);
    void supprimer(Long id);
    Module get(Long id);
    List<Module> list();
}
