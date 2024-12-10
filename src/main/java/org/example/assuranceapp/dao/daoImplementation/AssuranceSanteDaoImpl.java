package org.example.assuranceapp.dao.daoImplementation;

import org.example.assuranceapp.dao.daoInterface.AssuranceSanteDaoInt;
import org.example.assuranceapp.models.AssuranceHabitation;
import org.example.assuranceapp.models.AssuranceSante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class AssuranceSanteDaoImpl implements AssuranceSanteDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertAssuranceSante(AssuranceSante assuranceSante) {
        entityManager.persist(assuranceSante);
    }

    @Override
    @Transactional
    public List<AssuranceSante> getAssuranceSanteByUserId(Long userId) {
        return entityManager.createQuery(
                        "SELECT ah FROM AssuranceSante ah WHERE ah.utilisateur.id = :userId", AssuranceSante.class)
                .setParameter("userId", userId)
                .getResultList();
    }

}
