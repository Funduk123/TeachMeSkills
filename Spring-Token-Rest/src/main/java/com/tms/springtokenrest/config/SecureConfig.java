package com.tms.springtokenrest.config;

import com.tms.springtokenrest.TokenGeneratorFilter;
import com.tms.springtokenrest.TokenValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecureConfig extends WebSecurityConfigurerAdapter {

    private final TokenValidationFilter validationFilter;

    private final TokenGeneratorFilter generatorFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .authorizeRequests()
                .antMatchers("/", "login").permitAll()
                .antMatchers("/test").authenticated()
                .and()
                .addFilterBefore(validationFilter, LogoutFilter.class)
                .addFilterAfter(generatorFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
