package org.example.assuranceapp.dao.daoImplementation;

import net.bytebuddy.asm.Advice;
import org.example.assuranceapp.dao.daoInterface.LocalisationDaoInt;
import org.example.assuranceapp.models.Localisation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class LocalisationDaoImpl implements LocalisationDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Localisation> getAllLocalisations() {
        return entityManager.createQuery("SELECT l FROM Localisation l", Localisation.class).getResultList();
    }

    @Override
    @Transactional
    public Localisation getLocalisationById(Long id) {
        return entityManager.find(Localisation.class, id);
    }
}
