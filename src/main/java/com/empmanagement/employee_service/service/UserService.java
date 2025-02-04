package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.dto.LoginRequest;
import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.model.Token;
import com.empmanagement.employee_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    @Autowired
    TokenService tokenService;

    public List<AppUser> getUser(String email) {

        List<AppUser> all = repo.findAll();
        return all;
    }


    public AppUser addUser(AppUser appUser) {
        return repo.save(appUser);
    }

    public void updateUser(AppUser appUser) {

        repo.save(appUser);
    }

    public void deleteUser(Integer id){
        AppUser appUser = repo.findById(id).orElse(null);
        if(appUser!=null){
            repo.delete(appUser);
        }
    }

    public AppUser getUserDetails(String email) {
        AppUser appUser = repo.findByEmail(email).orElse(null);
        return appUser;

    }

    public String verifyUserDetails(LoginRequest request) {
        Optional<AppUser> optionalUser = repo.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (optionalUser.isPresent()) {
            Token token = tokenService.generateToken();
            return token.getToken();
        }
        throw new RuntimeException("Invalid creds 401");
    }
}
