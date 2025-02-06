package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.model.Token;
import com.empmanagement.employee_service.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class TokenService {
    @Autowired
    private TokenRepo repo;

    public Token generateToken() {
        Token token = new Token();
        return repo.save(token);
    }

    public Boolean veriyfyToken(String token) {
        Optional<Token> optionalToken = repo.findByToken(token);
        if (optionalToken.isPresent()) {
            Token tokenObj = optionalToken.get();
            LocalDateTime time0 = tokenObj.getExpiredTime();
            LocalDateTime time1 = LocalDateTime.now();
            if (time1.isBefore(time0)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
