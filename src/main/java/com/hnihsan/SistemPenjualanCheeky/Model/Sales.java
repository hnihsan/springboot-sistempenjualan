package com.hnihsan.SistemPenjualanCheeky.Model;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Administrators administrators;
    private String customer;

    @ManyToMany(targetEntity = Products.class)
    private Set productsSet;

    public Sales(Long id, String customer, Administrators administrators, Set productsSet){
        this.id=id;
        this.customer=customer;
        this.administrators=administrators;
        this.productsSet=productsSet;
    }

    public Sales(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Administrators getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Administrators administrators) {
        this.administrators = administrators;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Set getProductsSet() {
        return productsSet;
    }

    public void setProductsSet(Set productsSet) {
        this.productsSet = productsSet;
    }
}
