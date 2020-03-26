package org.mbo;

import org.mbo.Entities.Produit;
import org.mbo.dao.ProduitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        ProduitRepository produitDao = ctx.getBean(EntityRepository.class);
        produitDao.save(new Produit("Hp",599.99,63));
        produitDao.save(new Produit("lenovo",1299.99,45));
        produitDao.save(new Produit("xiaomi",19999.99,83));
        List<Produit>  p2 = produitDao.findByDesignation("%io%");
        for (Produit p: p2) {
            System.out.println(p.getQuantity());
            System.out.println(p.getPrice());
            System.out.println(p.getDesignation());

        }

        List<Produit> produitList = produitDao.findAll();
        for (Produit p: produitList) {
            System.out.println(p.getDesignation());

        }
    }

}
