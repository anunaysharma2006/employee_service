package com.empmanagement.employee_service.service;

import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.model.MyUserDetails;
import com.empmanagement.employee_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser users = userRepo.findByUsername(username);
        if (users == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(users);
    }

}