package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.Assurance;
import org.example.assuranceapp.models.Devis;

import java.util.List;

public interface DevisServiceInt {
    void insertDevis(Devis devis);
    Devis getDevisById(int id);
    List<Devis> getAllDevis();
    void updateDevis(Devis devis);
    public Devis calculeDevis(Assurance assurance);
}
