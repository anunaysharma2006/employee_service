package com.empmanagement.employee_service.repository;

import com.empmanagement.employee_service.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Companyrepo extends JpaRepository <Company,Integer>{

}
