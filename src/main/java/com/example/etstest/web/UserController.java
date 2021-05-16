package com.example.etstest.web;

import com.example.etstest.model.User;
import com.example.etstest.service.UserCommandService;
import com.example.etstest.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private UserCommandService userCommandService;

    @GetMapping("/")
    public String getHIndex(Model model){
        model.addAttribute("title", "Home");

        return "index";
    }

    @GetMapping(value = "/list")
    public String home(Model model) {
        model.addAttribute("activePage", "list");
        model.addAttribute("users", userQueryService.getAllUsers());
        model.addAttribute("title", "List Users");

        return "list";
    }

    @PostMapping(value = "/register")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userCommandService.save(user);

        return "redirect:/list";
    }

    @GetMapping(value = "/register/test")
    public String saveTest() {
        userCommandService.save(new User("Hüseyin", "Biçen", "AB RH +", "+905555555555", "Umraniye / ISTANBUL"));

        return "redirect:/list";
    }

    @GetMapping(value = "/add")
    public String getAdd(Model model) {
        model.addAttribute("title", "User Registration");
        model.addAttribute("activePage", "add");
        model.addAttribute("user", new User());

        return "add";
    }

    @GetMapping(value = "/delete/{userId}")
    public String removeUser(@PathVariable("userId") Long userId) {
        userCommandService.delete(userId);

        return "redirect:/list";
    }
}
