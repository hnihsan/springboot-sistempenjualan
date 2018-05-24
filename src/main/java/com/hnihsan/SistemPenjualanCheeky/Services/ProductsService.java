package com.hnihsan.SistemPenjualanCheeky.Services;

import com.hnihsan.SistemPenjualanCheeky.Model.Products;

import java.util.List;

public interface ProductsService {
    List<Products> listProducts();
    Products SaveOrUpdate (Products products);
    Products getIdProducts(Integer id);
    void hapus (Integer id);
}
