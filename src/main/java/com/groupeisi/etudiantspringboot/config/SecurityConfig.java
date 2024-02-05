package com.groupeisi.etudiantspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(
                AbstractHttpConfigurer::disable
        ).cors(
                AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        aut->aut.anyRequest().permitAll()
                );
        return http.build();
    }
}
