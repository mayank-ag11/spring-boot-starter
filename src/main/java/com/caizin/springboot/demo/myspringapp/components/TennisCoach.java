package com.caizin.springboot.demo.myspringapp.components;

import com.caizin.springboot.demo.myspringapp.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
