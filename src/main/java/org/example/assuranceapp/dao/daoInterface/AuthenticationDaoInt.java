package org.example.assuranceapp.dao.daoInterface;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.assuranceapp.models.Utilisateur;

public interface AuthenticationDaoInt {

    public boolean Register(Utilisateur utilisateur);
    public Utilisateur Login(String email, String password);

}
