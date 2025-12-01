package hssaine.mohammedamine.ensam.dao;

import hssaine.mohammedamine.ensam.entities.Chanson;
import java.util.List;

public interface ChansonDao {
    void add(Chanson c);
    void update(Chanson c);
    void delete(Long id);
    Chanson findById(Long id);
    List<Chanson> findAll();
}
