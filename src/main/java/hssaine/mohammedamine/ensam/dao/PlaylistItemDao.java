package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.PlaylistItem;
import hssaine.mohammedamine.ensam.entities.PlaylistItemKey;
import java.util.List;

public interface PlaylistItemDao {
    void add(PlaylistItem item);
    void delete(PlaylistItemKey id);
    PlaylistItem findById(PlaylistItemKey id);
    List<PlaylistItem> findAll();
}
