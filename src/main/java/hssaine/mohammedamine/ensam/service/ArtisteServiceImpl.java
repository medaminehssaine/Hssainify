package hssaine.mohammedamine.ensam.service;

import hssaine.mohammedamine.ensam.dao.ArtisteDao;
import hssaine.mohammedamine.ensam.entities.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArtisteServiceImpl implements ArtisteService {

    @Autowired
    private ArtisteDao artisteDao;

    @Override
    public void ajouter(Artiste a) { artisteDao.add(a); }

    @Override
    public void modifier(Artiste a) { artisteDao.update(a); }

    @Override
    public void supprimer(Long id) { artisteDao.delete(id); }

    @Override
    public Artiste get(Long id) { return artisteDao.findById(id); }

    @Override
    public List<Artiste> list() { return artisteDao.findAll(); }
}
