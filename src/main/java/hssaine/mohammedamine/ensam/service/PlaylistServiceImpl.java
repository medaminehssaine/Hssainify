package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.dao.PlaylistDao;
import hssaine.mohammedamine.ensam.entities.Chanson;
import hssaine.mohammedamine.ensam.entities.Playlist;
import hssaine.mohammedamine.ensam.entities.PlaylistItem;
import hssaine.mohammedamine.ensam.entities.PlaylistItemKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistDao playlistDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouter(Playlist p) { playlistDao.add(p); }

    @Override
    public void modifier(Playlist p) { playlistDao.update(p); }

    @Override
    public void supprimer(Long id) { playlistDao.delete(id); }

    @Override
    public Playlist get(Long id) { return playlistDao.findById(id); }

    @Override
    public List<Playlist> list() { return playlistDao.findAll(); }

    @Override
    public void addSongToPlaylist(Long playlistId, Long chansonId, Integer ordre) {
        Playlist p = em.find(Playlist.class, playlistId);
        Chanson c = em.find(Chanson.class, chansonId);
        if (p != null && c != null) {
            PlaylistItem item = new PlaylistItem();
            item.setPlaylist(p);
            item.setChanson(c);
            item.setOrdre(ordre == null ? 0 : ordre);
            PlaylistItemKey key = new PlaylistItemKey(playlistId, chansonId);
            item.setId(key);
            em.persist(item);
            p.getItems().add(item);
        }
    }

    @Override
    public void removeSongFromPlaylist(Long playlistId, Long chansonId) {
        PlaylistItemKey key = new PlaylistItemKey(playlistId, chansonId);
        PlaylistItem item = em.find(PlaylistItem.class, key);
        if (item != null) {
            em.remove(item);
        }
    }
}
