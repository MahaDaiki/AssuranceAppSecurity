package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.AuthenticationDaoInt;
import org.example.assuranceapp.enums.Role;
import org.example.assuranceapp.models.Utilisateur;
import org.example.assuranceapp.service.serviceInterface.AuthenticationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Service
public class AuthenticationServiceImpl implements AuthenticationServiceInt {

    @Autowired
    private AuthenticationDaoInt authenticationDao;

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    @Override
    public boolean Register(Utilisateur utilisateur) {
//        String phoneNumber = String.valueOf(utilisateur.getTelephone()).trim();
//
//        if (!PHONE_PATTERN.matcher(phoneNumber).matches()) {
//            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
//        }

        if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty() ||
                utilisateur.getMotdepasse() == null || utilisateur.getMotdepasse().isEmpty() ||
                utilisateur.getAdresse() == null || utilisateur.getAdresse().isEmpty() ||
                utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
            throw new IllegalArgumentException("All fields are required.");
        }
        if (utilisateur.getRole() == null || utilisateur.getRole().name().isEmpty()) {
            utilisateur.setRole(Role.valueOf("ROLE_USER"));
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(utilisateur.getMotdepasse());
        utilisateur.setMotdepasse(hashedPassword);

        return authenticationDao.Register(utilisateur);
    }

    @Override
    public Utilisateur Login(String email, String password) {
        return authenticationDao.Login(email, password);
    }

    @Override
    public void logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }
}
