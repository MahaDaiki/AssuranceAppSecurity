package org.example.assuranceapp.dao.daoImplementation;


import org.example.assuranceapp.dao.daoInterface.DevisDaoInt;
import org.example.assuranceapp.models.Devis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class DevisDaoImpl implements DevisDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertDevis(Devis devis) {
        entityManager.persist(devis);
    }

    @Override
    @Transactional
    public Devis getDevisById(int id) {
        return entityManager.find(Devis.class, id);
    }

    @Override
    @Transactional
    public List<Devis> getAllDevis() {
        return entityManager.createQuery("SELECT d FROM Devis d", Devis.class).getResultList();

    }

    @Override
    @Transactional
    public void updateDevis(Devis devis) {
        entityManager.merge(devis);
    }
}
