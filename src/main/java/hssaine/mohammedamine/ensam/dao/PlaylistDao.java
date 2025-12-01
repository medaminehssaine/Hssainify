package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Playlist;
import java.util.List;

public interface PlaylistDao {
    void add(Playlist p);
    void update(Playlist p);
    void delete(Long id);
    Playlist findById(Long id);
    List<Playlist> findAll();
}
