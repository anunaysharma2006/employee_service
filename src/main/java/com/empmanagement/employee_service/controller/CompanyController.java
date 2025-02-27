package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Company;
import com.empmanagement.employee_service.service.CompanyService;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Company>> getCompany() {
        return new ResponseEntity<>(service.getCompany(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company comp) {
        return new ResponseEntity<>(service.addCompany(comp), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        return new ResponseEntity<>(service.updateCompany(company), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable int id) {
        return new ResponseEntity<>(service.deleteCompany(id), HttpStatus.ACCEPTED);
    }

}
