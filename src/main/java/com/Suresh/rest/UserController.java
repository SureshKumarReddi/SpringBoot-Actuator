package com.Suresh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Suresh.DAO.Database;
import com.Suresh.DTO.User;

@RestController
public class UserController {

    @Autowired
    private Database database;

    @GetMapping("/loadUsers")
    public List<User>  getUsers(){
        return database.getAllUsers();
    }


}