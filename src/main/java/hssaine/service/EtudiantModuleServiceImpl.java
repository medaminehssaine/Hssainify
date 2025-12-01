package ma.ensam.spring.service;

import ma.ensam.spring.dao.EtudiantModuleDao;
import ma.ensam.spring.entities.EtudiantModule;
import ma.ensam.spring.entities.EtudiantModuleKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("etudiantModuleService")
@Transactional
public class EtudiantModuleServiceImpl implements EtudiantModuleService {

    @Autowired
    private EtudiantModuleDao etudiantModuleDao;

    @Override
    public void ajouter(EtudiantModule em) {
        etudiantModuleDao.add(em);
    }

    @Override
    public void modifier(EtudiantModule em) {
        etudiantModuleDao.update(em);
    }

    @Override
    public void supprimer(EtudiantModuleKey id) {
        etudiantModuleDao.delete(id);
    }

    @Override
    public EtudiantModule get(EtudiantModuleKey id) {
        return etudiantModuleDao.find(id);
    }

    @Override
    public List<EtudiantModule> list() {
        return etudiantModuleDao.findAll();
    }
}
