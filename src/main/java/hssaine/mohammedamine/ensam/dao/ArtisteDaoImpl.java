package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Artiste;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArtisteDaoImpl implements ArtisteDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Artiste a) {
        em.persist(a);
    }

    @Override
    public void update(Artiste a) {
        em.merge(a);
    }

    @Override
    public void delete(Long id) {
        Artiste a = em.find(Artiste.class, id);
        if (a != null) em.remove(a);
    }

    @Override
    public Artiste findById(Long id) {
        return em.find(Artiste.class, id);
    }

    @Override
    public List<Artiste> findAll() {
        return em.createQuery("SELECT a FROM Artiste a", Artiste.class).getResultList();
    }
}
