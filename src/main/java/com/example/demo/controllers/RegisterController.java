package com.example.demo.controllers;

import com.example.demo.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user",new User());
        return "views/registerForm";
    }

}
