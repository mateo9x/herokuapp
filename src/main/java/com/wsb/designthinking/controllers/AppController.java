package com.wsb.designthinking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String Home(){
        return "index";
    }

    @GetMapping("/contact")
    public String Contact(){ return "contact";}
}
