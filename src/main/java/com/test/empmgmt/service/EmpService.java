package com.test.empmgmt.service;

import java.util.List;

import com.test.empmgmt.model.Empl;


public interface EmpService {
    List<Empl> getAllEmpls();
    void saveEmpl(Empl emp);
    Empl getEmplByID(long id);
    void deleteEmpl(long id);
}
