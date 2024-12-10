package org.example.assuranceapp.dao.daoImplementation;

import org.example.assuranceapp.dao.daoInterface.AssuranceHabitationDaoInt;
import org.example.assuranceapp.models.AssuranceHabitation;
import org.example.assuranceapp.models.Localisation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Repository
public class AssurranceHabitationDaoImpl implements AssuranceHabitationDaoInt {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertAssuranceHabitation(AssuranceHabitation assuranceHabitation) {
        Localisation localisation = entityManager.find(Localisation.class, assuranceHabitation.getLocalisation().getId());
        assuranceHabitation.setLocalisation(localisation);
        entityManager.persist(assuranceHabitation);
    }

    @Override
    public List<AssuranceHabitation> getHabitationAssuranceByUserId(Long userId) {
        return entityManager.createQuery(
                        "SELECT ah FROM AssuranceHabitation ah WHERE ah.utilisateur.id = :userId", AssuranceHabitation.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
