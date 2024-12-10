package org.example.assuranceapp.dao.daoImplementation;

import org.example.assuranceapp.dao.daoInterface.VehiculeDaoInt;
import org.example.assuranceapp.models.Vehicule;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
@Repository
public class VehiculeDaoImpl implements VehiculeDaoInt {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<Vehicule> getAllVehicules() {
        return entityManager.createQuery("SELECT v FROM Vehicule v", Vehicule.class).getResultList();
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return entityManager.find(Vehicule.class, id);
    }
}
