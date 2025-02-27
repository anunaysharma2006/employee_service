package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.dto.LoginRequest;
import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    public List<AppUser> getAllUsers() {
        return repo.findAll();
    }

    public AppUser addUser(AppUser appUser) {
        return repo.save(appUser);
    }

    public AppUser updateUser(AppUser appUser) {
        return repo.save(appUser);
    }

    public AppUser deleteUser(Integer id) {
        AppUser appUser=repo.findById(id).orElse(null);
        repo.delete(appUser);
        return appUser;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public AppUser register(AppUser users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return repo.save(users);

    }

    public String verifyUserDetails(LoginRequest request) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        } else {
            return "Fail";
        }
    }


}
