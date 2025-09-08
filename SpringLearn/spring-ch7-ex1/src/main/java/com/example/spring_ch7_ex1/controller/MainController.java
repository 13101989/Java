package com.example.spring_ch7_ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home_static")
    public String home_static() {
        return "redirect:/home_static.html";
    }

    @RequestMapping("/home_dynamic")
    public String home_dynamic(Model page) {
        page.addAttribute("username", "Valentin");
        page.addAttribute("color", "red");
        return "home_dynamic.html";
    }

    @RequestMapping("/home_query_param")
    public String home_query_param(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name,
            Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home_dynamic.html";
    }

    @RequestMapping("/home_path_variable/{color}")
    public String home_path_variable(
            @PathVariable String color,
            Model page) {
        page.addAttribute("username", "Valentin");
        page.addAttribute("color", color);
        return "home_dynamic.html";
    }
}
