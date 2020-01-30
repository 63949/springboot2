package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal){
        String email = principal.getName();
        Optional<User> user = userService.findOne(email);
        model.addAttribute("tasks",taskService.findUserTask(user));
        return "views/profile";
    }
}
