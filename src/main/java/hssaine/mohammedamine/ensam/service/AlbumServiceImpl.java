package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.dao.AlbumDao;
import hssaine.mohammedamine.ensam.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public void ajouter(Album a) { albumDao.add(a); }

    @Override
    public void modifier(Album a) { albumDao.update(a); }

    @Override
    public void supprimer(Long id) { albumDao.delete(id); }

    @Override
    public Album get(Long id) { return albumDao.findById(id); }

    @Override
    public List<Album> list() { return albumDao.findAll(); }
}
