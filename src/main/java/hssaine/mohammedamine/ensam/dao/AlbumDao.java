package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Album;
import java.util.List;

public interface AlbumDao {
    void add(Album a);
    void update(Album a);
    void delete(Long id);
    Album findById(Long id);
    List<Album> findAll();
}
