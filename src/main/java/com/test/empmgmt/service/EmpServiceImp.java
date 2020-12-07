package com.test.empmgmt.service;

import java.util.List;
import java.util.Optional;

import com.test.empmgmt.model.Empl;
import com.test.empmgmt.repository.EmpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImp  implements EmpService{
    
    @Autowired
    private EmpRepository empRepository;

   @Override
   public List<Empl> getAllEmpls() {
       return empRepository.findAll();
   } 

   @Override
   public void saveEmpl(Empl emp) {
       this.empRepository.save(emp);
   }

   @Override
   public Empl getEmplByID(long id) {
        Optional <Empl> optional = empRepository.findById(id);
        Empl empl = null;
        if(optional.isPresent()) {
            empl= optional.get();
        }
        else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return empl;
   }

   @Override
   public void deleteEmpl(long id) {
       this.empRepository.deleteById(id);
   }
}
