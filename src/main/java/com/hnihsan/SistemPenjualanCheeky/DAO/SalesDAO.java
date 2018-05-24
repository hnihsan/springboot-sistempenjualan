package com.hnihsan.SistemPenjualanCheeky.DAO;

import com.hnihsan.SistemPenjualanCheeky.Model.Administrators;
import com.hnihsan.SistemPenjualanCheeky.Model.Products;
import com.hnihsan.SistemPenjualanCheeky.Model.Sales;
import com.hnihsan.SistemPenjualanCheeky.Services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SalesDAO implements SalesService {
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Sales> listSales() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Sales", Sales.class).getResultList();
    }

    @Override
    public Set<Products> getProducts(Integer[] ids) {
        EntityManager em = emf.createEntityManager();
        Set<Products> productsSet = new HashSet<>();
        for(Integer id:ids){
            Products data= em.find(Products.class, id);
            productsSet.add(data);
        }

        return productsSet;
    }

    @Override
    public List<Products> listProducts() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Products", Products.class).getResultList();
    }

    @Override
    public List<Administrators> listAdministrators() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Administrators", Administrators.class).getResultList();
    }

    @Override
    public void SaveOrUpdate(Sales sales, Set<Products> productsSet) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Sales saved = sales;
        saved.setProductsSet(productsSet);
        em.persist(saved);
        em.getTransaction().commit();

    }

    @Override
    public Sales getIdSales(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Sales.class, id);
    }


    @Override
    public Administrators getAdministrators(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Administrators.class, id);
    }


}
