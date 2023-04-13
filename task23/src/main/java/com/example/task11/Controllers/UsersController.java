package com.example.task11.Controllers;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.User;
import com.example.task11.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/registration")
    public String registration() {
        return "reg";
    }

    @PostMapping("/registration")
    public String AddUser(User user, Model model) {
        if (!usersService.addUser(user.getUsername(), user.getPassword())) {
            return "registration";
        }
        return "redirect:/login";
    }



//    private UsersService usersService;
//
//    @PostMapping("")
//    @ResponseBody
//    public void createUser(@RequestParam String login, @RequestParam String password) {
//        usersService.addUser(login,password);
//    }
//
//    @DeleteMapping("/{login}")
//    public void deleteUser(@PathVariable String login) {
//        usersService.remove(login);
//    }
//
//    @GetMapping("")
//    public List<User> getAllUsers() {
//        return usersService.getAll();
//    }

}
