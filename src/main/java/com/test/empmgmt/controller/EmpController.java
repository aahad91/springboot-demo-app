package com.test.empmgmt.controller;

import com.test.empmgmt.model.Empl;
import com.test.empmgmt.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listemps", empService.getAllEmpls());
        return "index";
    }

    @GetMapping("/new_emp")
    public String showNewEmployeeForm(Model model) {
        Empl emp = new Empl();
        model.addAttribute("emp", emp);
        return "new_emp";
    }

    @PostMapping("/saveEmp")
    public String saveEmp(@ModelAttribute("emp") Empl emp) {
        empService.saveEmpl(emp);
        return "redirect:/";
    }

    @GetMapping("/showEmp/{id}")
    public String showEmp(@PathVariable(value = "id") long id, Model model) {
        Empl emp = empService.getEmplByID(id);
        model.addAttribute("emp", emp);
        return "update_emp";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable(value = "id") long id) {
        this.empService.deleteEmpl(id);
        return "redirect:/";
    } 
}
