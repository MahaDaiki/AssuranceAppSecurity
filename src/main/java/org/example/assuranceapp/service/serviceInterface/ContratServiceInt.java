package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.Contrat;

public interface ContratServiceInt {
    Contrat saveContrat(Contrat contrat);
    void updateContrat(Contrat contrat);
    void deleteContrat(Long id);
    Contrat findContratById(Long id);
}
