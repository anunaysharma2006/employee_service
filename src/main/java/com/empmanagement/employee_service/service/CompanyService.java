package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.model.Company;
import com.empmanagement.employee_service.repository.Companyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService {

    @Autowired
    Companyrepo repo;

    public List<Company> getCompany(String name) {

        List<Company> all = repo.findAll();
        return all;
    }

    public void addCompany(Company comp) {
            repo.save(comp);
    }

    public void updateCompany(Company comp) {

        repo.save(comp);
    }

    public void deleteProduct(int CompanyId){
        Company company = repo.findById(CompanyId).orElse(null);
        if(company!=null){
            repo.delete(company);
        }
    }
}
