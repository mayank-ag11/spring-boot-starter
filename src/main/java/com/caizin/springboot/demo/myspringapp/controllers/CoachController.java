package com.caizin.springboot.demo.myspringapp.controllers;

import com.caizin.springboot.demo.myspringapp.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private final Coach myCoach;

    @Autowired // Autowired annotation optional if only one constructor
    public CoachController(@Qualifier("cricketCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
