package com.empmanagement.employee_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String roles;

    public AppUser(String email, String username, String password, String roles) {

        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}