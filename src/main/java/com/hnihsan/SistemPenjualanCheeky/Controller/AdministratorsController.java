package com.hnihsan.SistemPenjualanCheeky.Controller;

import com.hnihsan.SistemPenjualanCheeky.Model.Administrators;
import com.hnihsan.SistemPenjualanCheeky.Services.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.List;

@Controller
public class AdministratorsController {

    private AdministratorsService administratorsService;

    @Autowired
    public void setAdministratorsService(AdministratorsService administratorsService) {
        this.administratorsService = administratorsService;
    }

    @RequestMapping("/Administrators")
    public String AdministratorsList(Model model) {
        model.addAttribute("administrators", administratorsService.listAdministrators());
        return "Administrators";
    }

    @RequestMapping(value = "/Administrators/Tambah", method = RequestMethod.GET)
    public String TambahForm(Model model) {
        model.addAttribute("administrators", new Administrators());
        return "AdministratorsForm";
    }

    @RequestMapping(value = "/Administrators/Tambah", method = RequestMethod.POST)
    public String SimpanData(Model model, Administrators administrators) {
        model.addAttribute("administrators", administratorsService.SaveOrUpdate(administrators));
        return "redirect:/Administrators";
    }

    @RequestMapping(value = "/Administrators/Ubah/{id}", method = RequestMethod.GET)
    public String EditForm(@PathVariable Integer id, Model model){
        model.addAttribute("administrators", administratorsService.getIdAdministrators(id));
        return "AdministratorsForm";
    }

    @RequestMapping(value = "/Administrators/Hapus/{id}")
    public String HapusData(@PathVariable Integer id){
        administratorsService.hapus(id);
        return "redirect:/Administrators";
    }
}
