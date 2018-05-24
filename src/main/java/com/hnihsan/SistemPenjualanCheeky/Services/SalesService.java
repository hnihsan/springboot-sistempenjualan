package com.hnihsan.SistemPenjualanCheeky.Services;

import com.hnihsan.SistemPenjualanCheeky.Model.Administrators;
import com.hnihsan.SistemPenjualanCheeky.Model.Products;
import com.hnihsan.SistemPenjualanCheeky.Model.Sales;

import java.util.List;
import java.util.Set;

public interface SalesService {
    List<Sales> listSales();
    Set<Products> getProducts(Integer[] ids);
    Administrators getAdministrators(Integer id);

    List<Administrators> listAdministrators();
    List<Products> listProducts();
    void SaveOrUpdate (Sales products, Set<Products> productsSet);
    Sales getIdSales(Long id);




}
