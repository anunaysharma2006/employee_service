package com.empmanagement.employee_service.repository;

import com.empmanagement.employee_service.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TokenRepo extends JpaRepository<Token,Integer> {
    Optional<Token> findByToken(String Authorization);
}
