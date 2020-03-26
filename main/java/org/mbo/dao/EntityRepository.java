package org.mbo.dao;



import java.util.List;

public interface EntityRepository<T> {
    public T save(T t);
    public List<T> findAll();
    public List<T> findByDesignation(String mc);
    public T findOne(Long id);
    public T update(T p);
    public void delete(Long id);
}
