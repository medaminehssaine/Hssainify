package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Playlist;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PlaylistDaoImpl implements PlaylistDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Playlist p) { em.persist(p); }

    @Override
    public void update(Playlist p) { em.merge(p); }

    @Override
    public void delete(Long id) {
        Playlist p = em.find(Playlist.class, id);
        if (p != null) em.remove(p);
    }

    @Override
    public Playlist findById(Long id) { return em.find(Playlist.class, id); }

    @Override
    public List<Playlist> findAll() { return em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList(); }
}
