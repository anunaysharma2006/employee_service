package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;

    @GetMapping
    public List<Address> getAddress() {
        return service.getAddress();
    }

    @PostMapping
    public void addAddress(@RequestBody Address addr) {

        service.addAddress(addr);
    }

    @PutMapping
    public void updateProduct(@RequestBody Address addr) {

        service.updateAddress(addr);

    }

    @DeleteMapping("{Zip}")
    public void deleteAddress(@PathVariable int Zip) {
        service.deleteAddress(Zip);
    }
}
