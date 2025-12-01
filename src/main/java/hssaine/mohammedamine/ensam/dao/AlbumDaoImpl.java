package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Album;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AlbumDaoImpl implements AlbumDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Album a) { em.persist(a); }

    @Override
    public void update(Album a) { em.merge(a); }

    @Override
    public void delete(Long id) {
        Album a = em.find(Album.class, id);
        if (a != null) em.remove(a);
    }

    @Override
    public Album findById(Long id) { return em.find(Album.class, id); }

    @Override
    public List<Album> findAll() { return em.createQuery("SELECT a FROM Album a", Album.class).getResultList(); }
}
