package ma.ensam.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensam.spring.entities.EtudiantModule;
import ma.ensam.spring.entities.EtudiantModuleKey;

@Repository
@Transactional
public class EtudiantModuleDaoImpl implements EtudiantModuleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(EtudiantModule emod) {
        em.merge(emod);   // Très important ! évite les erreurs de detached entity
    }

    @Override
    public void update(EtudiantModule emod) {
        em.merge(emod);
    }

    @Override
    public void delete(EtudiantModuleKey id) {
        EtudiantModule emod = em.find(EtudiantModule.class, id);
        if (emod != null) {
            em.remove(emod);
        }
    }

    @Override
    public EtudiantModule find(EtudiantModuleKey id) {
        return em.find(EtudiantModule.class, id);
    }

    @Override
    public List<EtudiantModule> findAll() {
        return em.createQuery("SELECT e FROM EtudiantModule e", EtudiantModule.class)
                .getResultList();
    }
}
