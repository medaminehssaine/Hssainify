package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.entities.Chanson;
import java.util.List;

public interface ChansonService {
    void ajouter(Chanson c);
    void modifier(Chanson c);
    void supprimer(Long id);
    Chanson get(Long id);
    List<Chanson> list();
}
