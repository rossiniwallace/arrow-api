package br.com.arrow.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
       return http
               .csrf(csrf -> csrf.disable())
               .httpBasic(basic -> basic.disable())
               .sessionManagement(sm ->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .authorizeHttpRequests(requests -> requests
                       .requestMatchers("/auth/**").permitAll())
               .build();
    }
}