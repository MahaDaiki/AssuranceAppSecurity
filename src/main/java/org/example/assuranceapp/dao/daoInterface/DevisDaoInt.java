package org.example.assuranceapp.dao.daoInterface;

import org.example.assuranceapp.models.Devis;

import java.util.List;

public interface DevisDaoInt {
    void insertDevis(Devis devis);
    Devis getDevisById(int id);
    List<Devis> getAllDevis();
    void updateDevis(Devis devis);
}
