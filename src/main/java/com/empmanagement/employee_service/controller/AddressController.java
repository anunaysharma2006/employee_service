package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.advisor.EmptyInputException;
import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;

    private static final Logger logger= LoggerFactory.getLogger(AddressController.class);

    @GetMapping
    public List<Address> getAddress() {
        return service.getAddress();
    }

    @PostMapping
    public void addAddress(@RequestBody Address addr) {
            if(addr.getZip()!=0 || addr.getCity()!=null || addr.getState()!=null) {
                service.addAddress(addr);
            }else {
                logger.info("required fields are not filled");
                throw new EmptyInputException();
            }




    }

    @PutMapping
    public void updateAddress(@RequestBody Address addr) {
        if(addr.getZip()==0){
            throw new EmptyInputException();
        }
        service.updateAddress(addr);

    }

    @DeleteMapping("{Zip}")
    public void deleteAddress(@PathVariable int Zip) {
        service.deleteAddress(Zip);
    }
}
