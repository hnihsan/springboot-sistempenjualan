package com.hnihsan.SistemPenjualanCheeky.Controller;

import com.hnihsan.SistemPenjualanCheeky.Model.Products;
import com.hnihsan.SistemPenjualanCheeky.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/Products")
    public String ProductsList(Model model){
        model.addAttribute("products", productsService.listProducts());
        return "Products";
    }

    @RequestMapping(value = "/Products/Tambah", method = RequestMethod.GET)
    public String TambahForm(Model model) {
        model.addAttribute("products", new Products());
        return "ProductsForm";
    }

    @RequestMapping(value = "/Products/Tambah", method = RequestMethod.POST)
    public String SimpanData(Model model, Products products) {
        model.addAttribute("products", productsService.SaveOrUpdate(products));
        return "redirect:/Products";
    }

    @RequestMapping(value = "/Products/Ubah/{id}", method = RequestMethod.GET)
    public String EditForm(@PathVariable Integer id, Model model){
        model.addAttribute("products", productsService.getIdProducts(id));
        return "ProductsForm";
    }

    @RequestMapping(value = "/Products/Hapus/{id}")
    public String HapusData(@PathVariable Integer id){
        productsService.hapus(id);
        return "redirect:/Products";
    }

}
