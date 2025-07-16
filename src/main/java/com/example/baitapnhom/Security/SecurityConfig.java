package com.example.baitapnhom.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Dùng BCrypt để khớp với DB
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll()
                        .requestMatchers("/books/add").hasRole("ADMIN")
                        .requestMatchers("/books/borrow/**").hasRole("USER")
                        .requestMatchers("/books/{id}").hasRole("ADMIN")
                        .requestMatchers("/books").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/books/return/**").hasRole("USER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/books", true)
                        .permitAll())
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
