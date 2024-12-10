package org.example.assuranceapp.controllers;

import org.example.assuranceapp.models.Utilisateur;
import org.example.assuranceapp.service.serviceInterface.AuthenticationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

@Autowired
    private AuthenticationServiceInt authenticationService;

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
        Utilisateur utilisateur = authenticationService.Login(email, motdepasse);
        if (utilisateur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", utilisateur);
            return "redirect:/home?message=Login successful!";
        } else {
            return "redirect:/auth/login?error=Login failed!";
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
