package org.example.assuranceapp.controllers;

import lombok.AllArgsConstructor;
import org.example.assuranceapp.exception.EmptyException;
import org.example.assuranceapp.models.Utilisateur;
import org.example.assuranceapp.service.serviceInterface.AuthenticationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/auth")
public class AuthenticationController {

@Autowired
    private AuthenticationServiceInt authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String register(@ModelAttribute("utilisateur")  Utilisateur utilisateur) {
    if (authenticationService.Register(utilisateur)) {
        return "redirect:/auth/login?message=Registration successful!";
    } else {
        return "redirect:/auth/Register?error=Registration failed!";
    }
}
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String motdepasse , HttpServletRequest request) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(email, motdepasse);
            Authentication authenticatedUser = authenticationManager.authenticate(authentication);

            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            System.out.println(authentication);

            return "redirect:/home?message=Login successful!";
        } catch (EmptyException ex) {

            return "redirect:/auth/login?error=" + ex.getMessage();
        } catch (BadCredentialsException ex) {

            return "redirect:/auth/login?error=Invalid email or password!";
        } catch (AuthenticationException ex) {

            return "redirect:/auth/login?error=Authentication failed! " + ex.getMessage();
        } catch (Exception e) {
            return "redirect:/auth/login?error=Login failed due to an unexpected error!";
        }

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        authenticationService.logout(session);
        return "redirect:/auth/login?message=Logout successful!";
    }

//    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("utilisateur", new Utilisateur());
//        return "register";
//
//    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }
}
