package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.model.Address;
import com.empmanagement.employee_service.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepo repo;

    public List<Address> getProducts(String name) {

        List<Address> all = repo.findAll();
        return all;
    }


    public void addCompany(Address addr) {
            repo.save(addr);

    }
    public void updateCompany(Address addr) {

        repo.save(addr);
    }

    public void deleteProduct(int Zip){
        Address address = repo.findById(Zip).orElse(null);
        if(address!=null){
            repo.delete(address);
        }
    }
}
