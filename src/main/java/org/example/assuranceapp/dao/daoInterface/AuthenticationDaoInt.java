package org.example.assuranceapp.dao.daoInterface;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.assuranceapp.models.Utilisateur;

public interface AuthenticationDaoInt {

    boolean Register(Utilisateur utilisateur);
    Utilisateur Login(String email, String password);
    Utilisateur getUserByEmail(String email);
}
