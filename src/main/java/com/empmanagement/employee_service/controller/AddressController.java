package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.advisor.EmptyInputException;
import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        log.info("inside getAddress");
        return new ResponseEntity<>(service.getAddress(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {         //
        if (address.getZip() != 0 || address.getCity() != null || address.getState() != null) {
            return new ResponseEntity<>(service.addAddress(address), HttpStatus.CREATED);
        } else {
            logger.info("required fields are not filled");
            throw new EmptyInputException();
        }
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address addr) {
        if (addr.getZip() == 0) {
            throw new EmptyInputException();
        }
        return new ResponseEntity<>(service.updateAddress(addr), HttpStatus.OK);
    }

    @DeleteMapping("{Zip}")
    public ResponseEntity<Address> deleteAddress(@PathVariable int Zip) {
        return new ResponseEntity<>(service.deleteAddress(Zip), HttpStatus.ACCEPTED);
    }
}
