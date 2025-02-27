package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.advisor.DuplicateDataException;
import com.empmanagement.employee_service.advisor.EntityObjectNotFoundException;
import com.empmanagement.employee_service.controller.AddressController;
import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.repository.AddressRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressService {

    @Autowired
    AddressRepo repo;

    public List<Address> getAddress() {
        List<Address> all = repo.findAll();
        return all;
    }

    public Address addAddress(Address addr) {
        Address address = repo.findByZip(addr.getZip());
        if (address == null) {
            repo.save(addr);
            return repo.save(addr);
        } else {
            log.error("Duplicate object is inserted");
            throw new DuplicateDataException();
        }
    }

    public Address updateAddress(Address addr) {
        Address address = repo.findByZip(addr.getZip());
        if (address == null) {
            throw new EntityObjectNotFoundException();
        }
        return repo.save(addr);
    }

    public Address deleteAddress(int Zip) {
        Address address = repo.findById(Zip).orElse(null);
        if (address != null) {
            repo.delete(address);
            return address;
        }else{
            throw new EntityObjectNotFoundException();
        }
    }
}
