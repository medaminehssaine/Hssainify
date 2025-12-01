package ma.ensam.spring.dao;

import java.util.List;

public interface IDao<T> {
    void add(T o);
    void update(T o);
    void delete(Long id);
    T findById(Long id);
    List<T> findAll();
}
