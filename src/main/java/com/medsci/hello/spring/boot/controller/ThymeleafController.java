package com.medsci.hello.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("name", "学长");
        return "index";
    }
}
