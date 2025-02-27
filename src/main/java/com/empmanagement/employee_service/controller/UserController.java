package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PutMapping
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser appUser) {
        return new ResponseEntity<>(service.updateUser(appUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable Integer id) {
        return new ResponseEntity<>(service.deleteUser(id), HttpStatus.OK);
    }

}
