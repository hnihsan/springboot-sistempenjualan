package com.hnihsan.SistemPenjualanCheeky.DAO;

import com.hnihsan.SistemPenjualanCheeky.Model.Products;
import com.hnihsan.SistemPenjualanCheeky.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class ProductsDAO implements ProductsService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }



    @Override
    public List<Products> listProducts() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Products", Products.class).getResultList();
    }

    @Override
    public Products SaveOrUpdate(Products products) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Products saved = em.merge(products);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Products getIdProducts(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Products.class, id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Products.class, id));
        em.getTransaction().commit();
    }

}
