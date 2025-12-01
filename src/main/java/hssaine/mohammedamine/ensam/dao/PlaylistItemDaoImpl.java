package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.PlaylistItem;
import hssaine.mohammedamine.ensam.entities.PlaylistItemKey;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PlaylistItemDaoImpl implements PlaylistItemDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(PlaylistItem item) {
        em.persist(item);
    }

    @Override
    public void delete(PlaylistItemKey id) {
        PlaylistItem item = em.find(PlaylistItem.class, id);
        if (item != null) em.remove(item);
    }

    @Override
    public PlaylistItem findById(PlaylistItemKey id) {
        return em.find(PlaylistItem.class, id);
    }

    @Override
    public List<PlaylistItem> findAll() {
        return em.createQuery("SELECT p FROM PlaylistItem p", PlaylistItem.class).getResultList();
    }
}
