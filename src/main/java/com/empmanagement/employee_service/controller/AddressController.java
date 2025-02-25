package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService service;

    @GetMapping("/address")           //FOR SEEING ALL THE COMPANY
    public List<Address> getProduct(@RequestParam(required = false) String name) {
        return service.getProducts(name);
    }

    @PostMapping("/address")           //FOR POSTING THE COMPANY
    public void addAddress(@RequestBody Address addr) {

        service.addAddress(addr);
    }

    @PutMapping("/address")
    public void updateProduct(@RequestBody Address addr) {

        service.updateCompany(addr);

    }

    @DeleteMapping("/address/{Zip}")
    public void deleteProduct(@PathVariable int Zip) {
        service.deleteProduct(Zip);
    }
}
