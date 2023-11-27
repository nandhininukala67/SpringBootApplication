package com.example.projectDemo.controller;

import com.example.projectDemo.model.UsersModel;import com.example.projectDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new UsersModel());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest",new UsersModel());
        return "login_page";
    }
    @PostMapping("/register")
    public  String register(@ModelAttribute UsersModel usersModel){
        System.out.println("register request:"+usersModel);
        UsersModel registeredUser=userService.registerUSer(usersModel.getLogin(),usersModel.getPassword(),usersModel.getEmail());
       return registeredUser==null? "error_page":"redirect:/login";
    }
    @PostMapping("/login")
    public  String login(@ModelAttribute UsersModel usersModel,Model model){
        System.out.println("login request:"+usersModel);
        UsersModel authenticated=userService.authenticate(usersModel.getLogin(),usersModel.getPassword());
        if(authenticated!=null) {
            model.addAttribute("userLogin",authenticated.getLogin());
            return "personal_page";
        }
        else {
            return "error_page";

        }
    }

}
