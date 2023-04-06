package com.tms.springtokenrest;

import com.tms.springtokenrest.domain.User;
import com.tms.springtokenrest.service.TokenService;
import com.tms.springtokenrest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TokenGeneratorFilter extends OncePerRequestFilter {

    private final TokenService service;

    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = request.getParameter("username");
        User user = userService.getByUsername(username);

        if (user != null) {

            List<SimpleGrantedAuthority> collect = user.getAuths()
                    .stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getLogin(), "", collect);

            String tokensString = service.createToken(token);
            response.setHeader("token", tokensString);
        }

        filterChain.doFilter(request, response);

    }
}
