package org.example.assuranceapp.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.assuranceapp.service.serviceImplementation.CustomUserDetailServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Component
@ComponentScan(basePackages = "org.example.assuranceapp")
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private CustomUserDetailServiceImpl userDetailsService;

    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                System.out.println("Authenticating user: " + email);
        System.out.println("Provided password: " + password);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new AuthenticationException("Invalid credentials") {};
        }
                System.out.println(userDetails.getUsername());
        System.out.println(passwordEncoder.matches(password, userDetails.getPassword()));
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
