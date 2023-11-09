package com.mykhailobiesiedin.spring.rest.spring_course_mvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigSecurity {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(x -> x.disable())
                .authorizeHttpRequests(
                        x -> x
                                .requestMatchers(HttpMethod.GET, "/employee")
                                .permitAll()
                                .requestMatchers(HttpMethod.GET, "/employee/{id}")
                                .hasAnyRole("ADMIN", "EMPLOYEE")
                                .requestMatchers(HttpMethod.DELETE, "/employee/delete-by-id/{id}")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/employee/delete-by-name/{name}")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/employee")
                                .hasRole("ADMIN")
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
       return http.build();
    }

}
