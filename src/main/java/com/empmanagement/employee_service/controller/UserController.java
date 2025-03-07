package com.empmanagement.employee_service.controller;

import com.empmanagement.employee_service.dto.DashboardEntityCount;
import com.empmanagement.employee_service.model.AppUser;
import com.empmanagement.employee_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3000")
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

    @GetMapping
    public ResponseEntity<List<AppUser>> getUser() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public  ResponseEntity<DashboardEntityCount> getCount(){
        return  new ResponseEntity<>(service.getUserCounts(),HttpStatus.OK);
    }
}
