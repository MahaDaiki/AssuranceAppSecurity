package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.AssuranceAutoDaoInt;
import org.example.assuranceapp.models.AssuranceAuto;
import org.example.assuranceapp.service.serviceInterface.AssuranceAutoServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AssuranceAutoServiceImpl implements AssuranceAutoServiceInt {

    @Autowired
    private AssuranceAutoDaoInt assuranceAutoDao;
    @Override
    public void insertAssuranceAuto(AssuranceAuto assuranceAuto) {
        System.out.println("Inserting AssuranceAuto service: " + assuranceAuto);
        if (assuranceAuto.getAgeConducteur() <= 18) {
            throw new IllegalArgumentException("L'âge du conducteur ne peut pas être négatif ou zéro.");
        }
        if (assuranceAuto.getUtilisationvehicule() == null || assuranceAuto.getUtilisationvehicule().trim().isEmpty()) {
            throw new IllegalArgumentException("L'utilisation du véhicule ne peut pas être vide.");
        }
        assuranceAutoDao.insertAssuranceAuto(assuranceAuto);
    }

    @Override
    public List<AssuranceAuto> getAssurancesByUserId(Long userId) {
        return assuranceAutoDao.getAssurancesByUserId(userId);
    }
}
