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

    @GetMapping(value = "/eregistrarwebapp/students/list")
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("students/list");
        return modelAndView;
    }

    @GetMapping(value = "/eregistrarwebapp/students/register")
    public String displayRegisterStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "students/register";
    }

    @PostMapping(value = "/eregistrarwebapp/students/register")
    public String addNewStudent(@Valid @ModelAttribute(value = "student") Student student, BindingResult bindingResult, Model model){
       if (bindingResult.hasErrors()){
           model.addAttribute("student",student);
           model.addAttribute("errors", bindingResult.getAllErrors());
           return "students/register";
       }
       studentService.saveStudent(student);
       return "redirect:/eregistrarwebapp/students/list";
    }

    @GetMapping(value = "/eregistrarwebapp/students/edit/{studentId}")
    public String editStudent(@PathVariable Integer studentId, Model model){
        Student student = studentService.getStudentById(studentId);
        if (student!=null){
            model.addAttribute("student", student);
            return "students/edit";
        }
        return "students/list";
    }
    @PostMapping(value = "/eregistrarwebapp/students/edit")
    public String updateBook(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "students/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/eregistrarwebapp/students/list";
    }

    @GetMapping(value = "/eregistrarwebapp/students/delete/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId, Model model){
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrarwebapp/students/list";
    }

    @GetMapping(value = {"/eregistrarwebapp/students/search", "/students/search"})
    public ModelAndView searchBooks(@RequestParam String searchString){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount",students.size());
        modelAndView.setViewName("students/list");
        return modelAndView;
    }



}
