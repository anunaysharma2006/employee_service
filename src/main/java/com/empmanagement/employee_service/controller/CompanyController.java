package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Company;
import com.empmanagement.employee_service.service.CompanyService;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService service;
    @Autowired
    UserService userService;

    @GetMapping
    public List<Company> getCompany() {
        return service.getCompany();
    }

    @PostMapping
    public void addCompany(@RequestBody Company comp) {
        service.addCompany(comp);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company) {
        service.updateCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable int id) {
        service.deleteCompany(id);
    }

}
