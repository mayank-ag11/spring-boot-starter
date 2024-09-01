package com.caizin.springboot.demo.myspringapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Note: "/api/*" for matching exactly one path segment under "/api"
        // "/api/**" for matching any number of path segments under "/api"

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
        );

        // Disable Cross Site Request Forgery (CSRF)
        // In general, not required for stateless REST APIs that use POST, PUT, PATCH or DELETE
        http.csrf(AbstractHttpConfigurer::disable);
        // http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));

        // Use HTTP Basic Auth
        http.httpBasic(Customizer.withDefaults());

        // Use the default login page
        http.formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user")
                // .password("{noop}user") // plain text password
                .password(passwordEncoder.encode("user")) // Encode password
                .roles("USER")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                // .password("{noop}manager")
                .password(passwordEncoder.encode("manager")) // Encode password
                .roles("USER", "MANAGER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                // .password("{noop}admin")
                .password(passwordEncoder.encode("admin")) // Encode password
                .roles("USER", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, manager, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for encoding passwords
    }
}

