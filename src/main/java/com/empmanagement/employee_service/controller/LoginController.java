package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.dto.LoginRequest;
import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService service;

    @PostMapping("/login")
    public ResponseEntity<String> verifyUserDetails(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(service.verifyUserDetails(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AppUser users) {
        return new ResponseEntity<>(service.register(users), HttpStatus.OK);
    }
}
