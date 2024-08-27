package com.caizin.springboot.demo.myspringapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    public AppRestController() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/team-info")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
}
