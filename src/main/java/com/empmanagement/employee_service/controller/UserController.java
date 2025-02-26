package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PutMapping
    public void updateUser(@RequestBody AppUser appUser){
        service.updateUser(appUser);

    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
    }

}
