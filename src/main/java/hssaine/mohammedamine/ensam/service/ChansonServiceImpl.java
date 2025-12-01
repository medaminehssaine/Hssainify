package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.dao.ChansonDao;
import hssaine.mohammedamine.ensam.entities.Chanson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChansonServiceImpl implements ChansonService {

    @Autowired
    private ChansonDao chansonDao;

    @Override
    public void ajouter(Chanson c) { chansonDao.add(c); }

    @Override
    public void modifier(Chanson c) { chansonDao.update(c); }

    @Override
    public void supprimer(Long id) { chansonDao.delete(id); }

    @Override
    public Chanson get(Long id) { return chansonDao.findById(id); }

    @Override
    public List<Chanson> list() { return chansonDao.findAll(); }
}
