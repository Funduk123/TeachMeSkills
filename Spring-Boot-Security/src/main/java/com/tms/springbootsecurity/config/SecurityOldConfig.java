package com.tms.springbootsecurity.config;

import com.tms.springbootsecurity.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityOldConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginpage", "/infopage").permitAll()
                .antMatchers("/mainpage").authenticated()
                .antMatchers("/pageread").hasAuthority("read")
                .antMatchers("/pagewrite").hasAuthority("write")
                .antMatchers("/pageuser").hasRole("USER")
                .antMatchers("/pageadmin").hasRole("ADMIN")
                .antMatchers("/create").permitAll()
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
                })
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth.userDetailsService(service)
                .passwordEncoder(bCryptPasswordEncoder);
//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("user").password("user").authorities("read").roles("USER")
//                .and()
//                .withUser("admin").password("admin").authorities("write").roles("ADMIN");
    }

}