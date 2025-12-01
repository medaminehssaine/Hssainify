package ma.ensam.spring.service;

import ma.ensam.spring.dao.FiliereDao;
import ma.ensam.spring.entities.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service            // 🔥 Indique à Spring que c’est un composant métier
@Transactional     // 🔥 Active les transactions JPA pour toutes les méthodes
public class FiliereServiceImpl implements FiliereService {

    @Autowired      // 🔥 Injection automatique du DAO
    private FiliereDao filiereDao;

    @Override
    public void ajouter(Filiere f) {
        filiereDao.add(f);
    }

    @Override
    public void modifier(Filiere f) {
        filiereDao.update(f);
    }

    @Override
    public void supprimer(Long id) {
        filiereDao.delete(id);
    }

    @Override
    public Filiere get(Long id) {
        return filiereDao.findById(id);
    }

    @Override
    public List<Filiere> list() {
        return filiereDao.findAll();
    }
}
