package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.dto.LoginRequest;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService service;
    @PostMapping("/login")
    public Boolean verifyUserDetails(@RequestBody LoginRequest loginRequest){

        return service.verifyUserDetails(loginRequest);
    }

}
