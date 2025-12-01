package ma.ensam.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ma.ensam.spring.entities.Etudiant;

@Repository
@Transactional
public class EtudiantDaoImpl implements EtudiantDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Etudiant e) {
        em.persist(e);
    }

    @Override
    public void update(Etudiant e) {
        em.merge(e);
    }

    @Override
    public void delete(Long id) {
        Etudiant e = em.find(Etudiant.class, id);
        if (e != null) {
            em.remove(e);
        }
    }

    @Override
    public Etudiant findById(Long id) {
        return em.find(Etudiant.class, id);
    }

    @Override
    public List<Etudiant> findAll() {
        return em.createQuery("SELECT e FROM Etudiant e", Etudiant.class)
                 .getResultList();
    }
}
