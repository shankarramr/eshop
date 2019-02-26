package com.gmail.shankar2k5.eshop.authservice.authenticator;

import com.gmail.shankar2k5.eshop.authservice.feignclient.UserFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationManager implements AuthenticationManager {

    public static final String EN = "en";

    public static final String SOURCE_AUTH = "Authentication";

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UsernamePasswordAuthenticationToken authenticationToken = null;
        if (username != null && password != null) {
            UserDTO user = userFeignClient.getUserByUsername(SOURCE_AUTH, EN, username);
            if (user == null || !AuthenticationUtil.matchPassword(user.getPassword(), password)) {
                throw new BadCredentialsException("Invalid Username/password");
            }
            authenticationToken = new UsernamePasswordAuthenticationToken(user, null,
                    Collections.singletonList(new SimpleGrantedAuthority("USER")));
        }
        return authenticationToken;
    }
}
