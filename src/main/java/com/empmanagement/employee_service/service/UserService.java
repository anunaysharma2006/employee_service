package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.dto.DashboardEntityCount;
import com.empmanagement.employee_service.dto.LoginRequest;
import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.repository.AddressRepo;
import com.empmanagement.employee_service.repository.Companyrepo;
import com.empmanagement.employee_service.repository.EmployeeRepo;
import com.empmanagement.employee_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    Companyrepo companyrepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    JWTService jwtService;


    @Cacheable("users")
    public List<AppUser> getAllUsers() {
        return repo.findAll();
    }
    @CacheEvict(value = "users", allEntries = true)
    public AppUser addUser(AppUser appUser) {
        return repo.save(appUser);
    }

    @CachePut(value = "users", key = "#user.id")
    public AppUser updateUser(AppUser appUser) {
        return repo.save(appUser);
    }
    @DeleteMapping("/{id}")
    public AppUser deleteUser(Integer id) {
        AppUser appUser=repo.findById(id).orElse(null);
        repo.delete(appUser);
        return appUser;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Cacheable("appUsers")
    public String register(AppUser users) {
        users.setPassword(encoder.encode(users.getPassword()));
        repo.save(users);
        return "success";

    }

    public String verifyUserDetails(LoginRequest request) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        } else {
            return "Fail";
        }
    }


    public List<AppUser> getUsers() {
        List<AppUser> all = repo.findAll();
        return all;
    }

    public DashboardEntityCount getUserCounts() {
        DashboardEntityCount count = new  DashboardEntityCount();
        count.setUserCount(repo.count());
        count.setCompanyCount(companyrepo.count());
        count.setAddressCount(addressRepo.count());
        count.setEmployeeCount(employeeRepo.count());

        return count;



    }
}
