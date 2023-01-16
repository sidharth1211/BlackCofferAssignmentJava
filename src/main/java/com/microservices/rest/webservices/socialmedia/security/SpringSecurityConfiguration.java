package com.microservices.rest.webservices.socialmedia.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1. All requests are authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // 2.  If a request isn't authenticated, show a webpage.
        http.httpBasic(withDefaults());
        // 3. CSRF Post and Put
        http.csrf().disable();

        return http.build();


    }
}