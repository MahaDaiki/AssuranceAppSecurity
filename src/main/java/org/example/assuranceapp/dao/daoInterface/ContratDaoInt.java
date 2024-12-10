package org.example.assuranceapp.dao.daoInterface;

import org.example.assuranceapp.models.Contrat;

public interface ContratDaoInt {
    Contrat saveContrat(Contrat contrat);
    void updateContrat(Contrat contrat);
    void deleteContrat(Long id);
    Contrat findContratById(Long id);
}
