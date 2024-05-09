package com.cydeo.controller;

import com.cydeo.bootsrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    //localhost8080/student/register
    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createStudent());
        return "student/register";
    }

    //localhost8080/student/welcome
    //@RequestMapping(value = "/welcome", method = RequestMethod.POST)
    @PostMapping("/welcome")
    public String welcome(@RequestParam String name){
        System.out.println(name);
        return "student/welcome";
    }

}
