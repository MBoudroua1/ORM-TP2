package org.mbo.dao;

import org.mbo.Entities.Produit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ProduitDaoImpl implements EntityRepository<Produit> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Produit save(Produit produit) {
        entityManager.persist(produit);
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        Query query = entityManager.createQuery("select p from Produit p");
        return query.getResultList();
    }

    @Override
    public List<Produit> findByDesignation(String mc) {
        Query req =entityManager.createQuery("select p from Produit p where p.designation like  :x");
        req.setParameter("x",mc) ;
        return req.getResultList();
    }

    @Override
    public Produit findOne(Long id) {
        Produit p = entityManager.find(Produit.class, id);

        return p;
    }

    @Override
    public Produit update(Produit p) {
        entityManager.merge(p);
        return p;
    }

    @Override
    public void delete(Long id) {
        Produit p = entityManager.find(Produit.class,id);
        entityManager.remove(p);

    }
}
