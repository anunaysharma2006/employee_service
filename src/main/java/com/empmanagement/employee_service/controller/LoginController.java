package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.dto.LoginRequest;
import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService service;

    @PostMapping("/login")
    public String verifyUserDetails(@RequestBody LoginRequest request){
        return service.verifyUserDetails(request);
    }
    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser users){
        return service.register(users);
    }
}
