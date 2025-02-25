package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Company;
import com.empmanagement.employee_service.service.CompanyService;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService service;
    @Autowired
    UserService userService;

    @GetMapping("/company")           //FOR SEEING ALL THE COMPANY
    public List<Company> getProduct(@RequestParam(required = false) String name) {
        return service.getCompany(name);
    }

    @PostMapping("/company")           //FOR POSTING THE COMPANY
    public void addProduct(@RequestBody Company comp) {
        service.addCompany(comp);
    }

    @PutMapping("/company")
    public void updateProduct(@RequestBody Company comp) {

        service.updateCompany(comp);

    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable int CompanyId) {
        service.deleteProduct(CompanyId);
    }

}
