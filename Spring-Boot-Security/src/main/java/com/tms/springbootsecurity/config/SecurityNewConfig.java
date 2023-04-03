package com.tms.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

//@Configuration
//@EnableWebSecurity
public class SecurityNewConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((auth) -> {
            try {
                auth
                        .antMatchers("/loginpage", "/infopage").permitAll()
                        .antMatchers("/mainpage")
                        .authenticated()
                        .and()
                        .cors().disable()
                        .csrf().disable()
                        .formLogin()
                        .loginPage("/loginpage").loginProcessingUrl("/try-login")
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/mainpage");
                        })
                        .usernameParameter("login")
                        .and()
                        .logout()
                        .logoutUrl("/try-logout")
                        .addLogoutHandler((request, response, authentication) -> {
                            try {
                                response.sendRedirect("/infopage");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).httpBasic();
        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        var user = User.builder().username("user").password("user").authorities("read").build();
        var admin = User.builder().username("admin").password("admin").authorities("read").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
