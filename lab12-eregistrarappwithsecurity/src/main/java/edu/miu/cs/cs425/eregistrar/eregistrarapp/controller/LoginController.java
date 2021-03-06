package edu.miu.cs.cs425.eregistrar.eregistrarapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/public/login","/eregistrarwebapp/public/login", "/eregistrarwebapp/public/logout"})
    public String login(){
        return "public/login";
    }

    @PostMapping(value = "/eregistrarwebapp/public/logout")
    public String logout(){
        return "redirect:/public/home";
    }

//    @PostMapping(value = {"/public/login","/eregistrarwebapp/public/login"})
//    public String success(){
//        return "redirect:eregistrarwebapp/secured/homepage";
//    }

}
