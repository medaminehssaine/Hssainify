package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Chanson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ChansonDaoImpl implements ChansonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Chanson c) { em.persist(c); }

    @Override
    public void update(Chanson c) { em.merge(c); }

    @Override
    public void delete(Long id) {
        Chanson c = em.find(Chanson.class, id);
        if (c != null) em.remove(c);
    }

    @Override
    public Chanson findById(Long id) { return em.find(Chanson.class, id); }

    @Override
    public List<Chanson> findAll() { return em.createQuery("SELECT c FROM Chanson c", Chanson.class).getResultList(); }
}
