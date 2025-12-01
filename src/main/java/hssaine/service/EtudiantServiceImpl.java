package ma.ensam.spring.service;

import ma.ensam.spring.dao.EtudiantDao;
import ma.ensam.spring.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service                     // 🔥 indispensable pour que Spring voie le bean
@Transactional              // 🔥 indispensable pour JPA
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired               // 🔥 injection automatique du DAO
    private EtudiantDao etudiantDao;

    @Override
    public void ajouter(Etudiant e) {
        etudiantDao.add(e);
    }

    @Override
    public void modifier(Etudiant e) {
        etudiantDao.update(e);
    }

    @Override
    public void supprimer(Long id) {
        etudiantDao.delete(id);
    }

    @Override
    public Etudiant get(Long id) {
        return etudiantDao.findById(id);
    }

    @Override
    public List<Etudiant> list() {
        return etudiantDao.findAll();
    }
}
