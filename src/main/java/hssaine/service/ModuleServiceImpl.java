package ma.ensam.spring.service;

import ma.ensam.spring.dao.ModuleDao;
import ma.ensam.spring.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service                    // 🔥 Indique que c’est un service Spring
@Transactional             // 🔥 Gère automatiquement les transactions JPA
public class ModuleServiceImpl implements ModuleService {

    @Autowired             // 🔥 Injection automatique du DAO
    private ModuleDao moduleDao;

    @Override
    public void ajouter(Module m) {
        moduleDao.add(m);
    }

    @Override
    public void modifier(Module m) {
        moduleDao.update(m);
    }

    @Override
    public void supprimer(Long id) {
        moduleDao.delete(id);
    }

    @Override
    public Module get(Long id) {
        return moduleDao.findById(id);
    }

    @Override
    public List<Module> list() {
        return moduleDao.findAll();
    }
}
