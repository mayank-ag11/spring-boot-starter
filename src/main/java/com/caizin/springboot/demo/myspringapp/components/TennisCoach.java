package com.caizin.springboot.demo.myspringapp.components;

import com.caizin.springboot.demo.myspringapp.interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Qualifier has higher precedence
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
