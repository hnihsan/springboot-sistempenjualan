package com.hnihsan.SistemPenjualanCheeky.Controller;

import com.hnihsan.SistemPenjualanCheeky.Model.Products;
import com.hnihsan.SistemPenjualanCheeky.Model.Sales;
import com.hnihsan.SistemPenjualanCheeky.Services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class SalesController {
    private SalesService salesService;

    @Autowired
    public void setSalesService(SalesService salesService) {
        this.salesService = salesService;
    }

    @RequestMapping("/Sales")
    public String SalesList(Model model){
        model.addAttribute("sales", salesService.listSales());
        return "Sales";
    }

    @RequestMapping(value = "/Sales/Tambah", method = RequestMethod.GET)
    public String TambahForm(Model model) {
        model.addAttribute("administrators", salesService.listAdministrators());
        model.addAttribute("products", salesService.listProducts());
        return "SalesForm";
    }

    @RequestMapping(value = "/Sales/Tambah", method = RequestMethod.POST)
    public String SimpanData(Model model, @RequestParam("customer") String customer,
                             @RequestParam("produkpilihan") Integer[] ids,
                             @RequestParam("id") Long id,
                             @RequestParam("administrators") Integer administrators) {
        Sales sales = new Sales();
        sales.setId(id);
        sales.setCustomer(customer);
        sales.setAdministrators(salesService.getAdministrators(administrators));
        Set<Products> productsSet = salesService.getProducts(ids);
        salesService.SaveOrUpdate(sales, productsSet);

        return "redirect:/Sales";
    }

    @RequestMapping(value = "/Sales/Ubah/{id}", method = RequestMethod.GET)
    public String EditForm(@PathVariable Long id, Model model){
        model.addAttribute("sales", salesService.getIdSales(id));
        return "ProductsForm";
    }

}
