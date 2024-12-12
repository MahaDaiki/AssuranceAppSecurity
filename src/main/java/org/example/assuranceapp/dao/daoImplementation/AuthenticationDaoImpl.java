package org.example.assuranceapp.dao.daoImplementation;

import org.example.assuranceapp.dao.daoInterface.AuthenticationDaoInt;
import org.example.assuranceapp.models.Utilisateur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository

public class AuthenticationDaoImpl implements AuthenticationDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean Register(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);
        return true;
    }

    @Override
    @Transactional
    public Utilisateur Login(String email, String motdepasse) {
        try {
            return entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.motdepasse = :motdepasse", Utilisateur.class)
                    .setParameter("email", email)
                    .setParameter("motdepasse", motdepasse)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Utilisateur getUserByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :email ", Utilisateur.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
