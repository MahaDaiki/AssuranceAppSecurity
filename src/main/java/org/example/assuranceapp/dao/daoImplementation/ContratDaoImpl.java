package org.example.assuranceapp.dao.daoImplementation;


import org.example.assuranceapp.dao.daoInterface.ContratDaoInt;
import org.example.assuranceapp.models.Contrat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ContratDaoImpl implements ContratDaoInt {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Contrat saveContrat(Contrat contrat) {
        entityManager.persist(contrat);
        return contrat;
    }

    @Override
    @Transactional
    public void updateContrat(Contrat contrat) {
        entityManager.merge(contrat);
    }

    @Override
    @Transactional
    public void deleteContrat(Long id) {
        Contrat contrat = entityManager.find(Contrat.class, id);
        if (contrat != null) {
            entityManager.remove(contrat);
        }
    }

    @Override
    @Transactional
    public Contrat findContratById(Long id) {
        return entityManager.find(Contrat.class, id);
    }
}
