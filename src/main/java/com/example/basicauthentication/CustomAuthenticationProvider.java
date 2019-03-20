package com.example.basicauthentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        System.out.println("Email: "+email);
        String password = authentication.getCredentials().toString();
        System.out.println("Password: "+password);
        
        User user = userService.findUserByEmail(email);
        
        

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("users"));

       if (user.getEmail().equals(email)  &&  user.getPassword().equals(password)) {
    	   System.out.println("Email123: "+email);
    	   System.out.println("Password123: "+password);
    	 return  new UsernamePasswordAuthenticationToken(email, password, authorities);
		}
        
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
