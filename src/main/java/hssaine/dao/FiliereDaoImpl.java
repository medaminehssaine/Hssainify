package ma.ensam.spring.dao;

import ma.ensam.spring.entities.Filiere;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FiliereDaoImpl implements FiliereDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Filiere f) {
        em.persist(f);
    }

    @Override
    public void update(Filiere f) {
        em.merge(f);
    }

    @Override
    public void delete(Long id) {
        Filiere f = em.find(Filiere.class, id);
        if (f != null) em.remove(f);
    }

    @Override
    public Filiere findById(Long id) {
        return em.find(Filiere.class, id);
    }

    @Override
    public List<Filiere> findAll() {
        return em.createQuery("SELECT f FROM Filiere f", Filiere.class)
                 .getResultList();
    }
}
