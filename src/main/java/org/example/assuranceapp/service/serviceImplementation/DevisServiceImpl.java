package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoImplementation.DevisDaoImpl;
import org.example.assuranceapp.dao.daoInterface.DevisDaoInt;
import org.example.assuranceapp.enums.type_de_couverture;
import org.example.assuranceapp.models.*;
import org.example.assuranceapp.service.serviceInterface.DevisServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
@Service
public class DevisServiceImpl implements DevisServiceInt {


    @Autowired
    private DevisDaoInt devisdao;

    @Override
    public void insertDevis(Devis devis) {
        devisdao.insertDevis(devis);
    }

    @Override
    public Devis getDevisById(int id) {
        return devisdao.getDevisById(id);
    }

    @Override
    public List<Devis> getAllDevis() {
        return devisdao.getAllDevis();
    }

    @Override
    public void updateDevis(Devis devis) {
        devisdao.updateDevis(devis);
    }

    @Override
    public Devis calculeDevis(Assurance assurance) {
        double montant = assurance.getBase();

        if (assurance instanceof AssuranceAuto) {
            AssuranceAuto auto = (AssuranceAuto) assurance;
            montant = calculateAutoDevis(auto, montant);

        } else if (assurance instanceof AssuranceHabitation) {
            AssuranceHabitation habitation = (AssuranceHabitation) assurance;
            montant = calculateHabitationDevis(habitation, montant);

        } else if (assurance instanceof AssuranceSante) {

            AssuranceSante sante = (AssuranceSante) assurance;
            montant = calculateSanteDevis(sante, montant);
        }


        return new Devis(
                assurance.getType().name(),
                montant,
                LocalDate.now(),
                false,
                assurance
        );
    }

    private double calculateAutoDevis(AssuranceAuto auto, double montant) {
        if (auto.getAgeConducteur() < 25) {
            montant += montant * 0.10;
        }
        if ("luxe".equalsIgnoreCase(auto.getVehicule().getType())) {
            montant += montant * 0.15;
        }
        if ("professionnelle".equalsIgnoreCase(auto.getUtilisationvehicule())) {
            montant += montant * 0.10;
        }
        return montant;
    }

    private double calculateHabitationDevis(AssuranceHabitation habitation, double montant) {

        if ("maison".equalsIgnoreCase(habitation.getTypeLogement().name())) {
            montant += montant * 0.02;
        }
        if (habitation.getLocalisation().isZoneRisques()) {
            montant += montant * 0.05;
        }
        if (habitation.getValeurBien() > 200000) {
            montant += montant * 0.10;
        }
        if (habitation.isSystemeSecurite()) {
            montant -= montant * 0.15;
        } else {
            montant += montant * 0.15;
        }
        return montant;
    }


    private double calculateSanteDevis(AssuranceSante sante, double montant) {
        if (sante.getAge() > 60) {
            montant += montant * 0.20;
        }
        if (sante.isMaladieChronique()) {
            montant += montant * 0.30;
            if (sante.getTypeDeCouverture() == type_de_couverture.basic) {
                montant -= montant * 0.10;
            } else if (sante.getTypeDeCouverture() == type_de_couverture.premium) {
                montant += montant * 0.05;
            }
            return montant;
        }

        return montant;
    }
}


