package com.caizin.springboot.demo.myspringapp.config;

import com.caizin.springboot.demo.myspringapp.components.SwimCoach;
import com.caizin.springboot.demo.myspringapp.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
