package com.empmanagement.employee_service.repository;

import com.empmanagement.employee_service.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}
