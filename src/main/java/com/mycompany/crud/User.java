/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.time.LocalDate;

/**
 *
 * @author isaias-vitor
 */
public class User implements Entity {
    
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate lastAccess;
    private Boolean active;
    
    
    // Construtores
    public User() {}

    public User(Long id, String name, String email, String password, LocalDate lastAccess, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastAccess = lastAccess;
        this.active = active;
    }
    
    
    // Da interface Entity
    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    
    //Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDate lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
    
}
