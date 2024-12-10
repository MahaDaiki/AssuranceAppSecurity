package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.Utilisateur;

import javax.servlet.http.HttpSession;

public interface AuthenticationServiceInt {
    public boolean Register(Utilisateur utilisateur);
    public Utilisateur  Login(String email, String password);
    void logout(HttpSession session);
}
