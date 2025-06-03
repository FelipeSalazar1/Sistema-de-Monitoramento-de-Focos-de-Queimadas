package com.fiap.queimadas.monitoramentos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF para facilitar testes em APIs REST
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // exige autenticação para todas as rotas
                )
                .httpBasic(Customizer.withDefaults()); // usa autenticação HTTP Basic

        return http.build();
    }
}
