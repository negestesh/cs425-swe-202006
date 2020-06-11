package edu.miu.cs.cs425.eregistrar.eregistrarapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping(value = {"/", "/index", "/home", "/eregistrarwebapp/home"})
    public String showHomepage() {
        return "home/index";
    }
}
