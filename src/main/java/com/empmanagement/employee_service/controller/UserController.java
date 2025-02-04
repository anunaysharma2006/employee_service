package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/adduser")        //FOR POSTING THE COMPANY
    public AppUser addUser(@RequestBody AppUser appUser){

       return service.addUser(appUser);
    }

    @PutMapping
    public void updateUser(@RequestBody AppUser appUser){
        service.updateUser(appUser);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
    }

    @GetMapping("/{email}")
    public AppUser getUserDetails(@PathVariable String email){

        return service.getUserDetails(email);
    }



}
