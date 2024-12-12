package org.example.assuranceapp.service.serviceImplementation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.assuranceapp.dao.daoInterface.AuthenticationDaoInt;
import org.example.assuranceapp.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private final AuthenticationDaoInt authenticationDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Utilisateur utilisateur = authenticationDao.getUserByEmail(email);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("User not found with this email: "+email);
        }

        return User.builder()
                .username(utilisateur.getEmail())
                .password(utilisateur.getMotdepasse())
                .roles(utilisateur.getRole().name())
                .build();
    }
}
