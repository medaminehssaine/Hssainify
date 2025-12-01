package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Artiste;
import java.util.List;

public interface ArtisteDao {
    void add(Artiste a);
    void update(Artiste a);
    void delete(Long id);
    Artiste findById(Long id);
    List<Artiste> findAll();
}
