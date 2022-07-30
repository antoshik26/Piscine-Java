package school21.spring.service.repositories;

import java.util.List;

public interface CrudRepository<T> {
    T findById(long Id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(T entity);

}
