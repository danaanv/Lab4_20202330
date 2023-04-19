package com.example.lab4_20202330.Controller;

import com.example.lab4_20202330.Entity.User;
import com.example.lab4_20202330.Repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Controller
public class Controller {

    final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/login")
    public String login(){
        return "inicio";
    }

    @PostMapping("/login/inicioSesion")
    public String iniciarSesion(User user){

        List<User> userList = repository.findAll();
        for(User u : userList){
            if(Objects.equals(user.getEmail(), u.getEmail()) && Objects.equals(user.getPassword(), u.getPassword())){
                return "homePage";
            }
        }
        return "inicio";
    }

}
