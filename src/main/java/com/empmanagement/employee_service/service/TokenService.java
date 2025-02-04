package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.model.Token;
import com.empmanagement.employee_service.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TokenService {
    @Autowired
    private TokenRepo repo;

    public Token generateToken() {
        Token token = new Token();
        return repo.save(token);
    }
}
