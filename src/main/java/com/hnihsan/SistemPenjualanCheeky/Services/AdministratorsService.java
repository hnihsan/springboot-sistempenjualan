package com.hnihsan.SistemPenjualanCheeky.Services;

import com.hnihsan.SistemPenjualanCheeky.Model.Administrators;

import java.util.List;

public interface AdministratorsService {
    List <Administrators> listAdministrators();
    Administrators SaveOrUpdate (Administrators administrators);
    Administrators getIdAdministrators(Integer id);
    void hapus (Integer id);
}
