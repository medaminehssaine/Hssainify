package ma.ensam.spring.dao;

import ma.ensam.spring.entities.Module;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ModuleDaoImpl implements ModuleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Module m) {
        em.persist(m);
    }

    @Override
    public void update(Module m) {
        em.merge(m);
    }

    @Override
    public void delete(Long id) {
        Module m = em.find(Module.class, id);
        if (m != null) {
            em.remove(m);
        }
    }

    @Override
    public Module findById(Long id) {
        return em.find(Module.class, id);
    }

    @Override
    public List<Module> findAll() {
        return em.createQuery("SELECT m FROM Module m", Module.class)
                 .getResultList();
    }
}
