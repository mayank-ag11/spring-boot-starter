package com.caizin.springboot.demo.testscan;

import com.caizin.springboot.demo.myspringapp.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
