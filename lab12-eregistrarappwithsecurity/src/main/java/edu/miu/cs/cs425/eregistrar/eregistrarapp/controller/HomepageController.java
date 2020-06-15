package edu.miu.cs.cs425.eregistrar.eregistrarapp.controller;

import edu.miu.cs.cs425.eregistrar.eregistrarapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {


    StudentService studentService;
    @Autowired
    public HomepageController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/", "/index", "/home", "/eregistrarwebapp/public/home"})
    public String showHomepage() {
        return "public/index";
    }

    @GetMapping(value = {"/public/about","/eregistrarwebapp/public/about"})
    public String about(){
        return "public/about";
    }


    @GetMapping(value = {"/eregistrarwebapp/public/list", "/eregistrarwebapp/secured/students/list"})
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("public/list");
        return modelAndView;
    }
    @PostMapping(value = "/eregistrarwebapp/public/login")
    public String loggedIn(){return "/secured/index";}


    @GetMapping(value = "/secured/homepage")
    public String showHomeLoggedIn(){
        return "/secured/index";
    }

//    @GetMapping(value = "/secured/student/homepage")
//    public String showHomeLoggedInStudent(){return "/secured/students/index";}
}
