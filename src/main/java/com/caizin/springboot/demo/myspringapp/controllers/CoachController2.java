package com.caizin.springboot.demo.myspringapp.controllers;

import com.caizin.springboot.demo.myspringapp.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController2 {
    private Coach myCoach;

    @Autowired // the method name can be anything
    public void setCoach(@Qualifier("tennisCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/daily-workout-2")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout() + " (V2)";
    }
}
