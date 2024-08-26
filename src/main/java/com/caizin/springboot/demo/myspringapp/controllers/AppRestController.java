package com.caizin.springboot.demo.myspringapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
}
