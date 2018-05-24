package com.hnihsan.SistemPenjualanCheeky.DAO;

import com.hnihsan.SistemPenjualanCheeky.Model.Administrators;
import com.hnihsan.SistemPenjualanCheeky.Services.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class AdministratorsDAO implements AdministratorsService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }



    @Override
    public List<Administrators> listAdministrators() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Administrators", Administrators.class).getResultList();
    }

    @Override
    public Administrators SaveOrUpdate(Administrators administrators) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Administrators saved = em.merge(administrators);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Administrators getIdAdministrators(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Administrators.class, id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Administrators.class, id));
        em.getTransaction().commit();
    }
}
