package edu.miu.cs.cs425.eregistrar.eregistrarapp.controller;

import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/eregistrarwebapp/secured/admin/list")
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("secured/admin/list");
        return modelAndView;
    }

    @GetMapping(value = "/eregistrarwebapp/secured/admin/register")
    public String displayRegisterStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "/secured/admin/register";
    }

    @PostMapping(value = "/eregistrarwebapp/secured/admin/register")
    public String addNewStudent(@Valid @ModelAttribute(value = "student") Student student, BindingResult bindingResult, Model model){
       if (bindingResult.hasErrors()){
           model.addAttribute("student",student);
           model.addAttribute("errors", bindingResult.getAllErrors());
           return "secured/admin/register";
       }
       studentService.saveStudent(student);
       return "redirect:/eregistrarwebapp/secured/admin/list";
    }

    @GetMapping(value = "/eregistrarwebapp/secured/admin/edit/{studentId}")
    public String editStudent(@PathVariable Integer studentId, Model model){
        Student student = studentService.getStudentById(studentId);
        if (student!=null){
            model.addAttribute("student", student);
            return "/secured/admin/edit";
        }
        return "/secured/admin/list";
    }
    @PostMapping(value = "/eregistrarwebapp/secured/admin/edit")
    public String updateBook(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/admin/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/eregistrarwebapp/secured/admin/list";
    }

    @GetMapping(value = "/eregistrarwebapp/secured/admin/delete/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId, Model model){
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrarwebapp/secured/admin/list";
    }

    @GetMapping(value = {"/eregistrarwebapp/secured/admin/search", "secured/admin/search"})
    public ModelAndView searchBooks(@RequestParam String searchString){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount",students.size());
        modelAndView.setViewName("/secured/admin/list");
        return modelAndView;
    }



}
