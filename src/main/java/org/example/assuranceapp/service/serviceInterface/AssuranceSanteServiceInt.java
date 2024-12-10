package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.AssuranceSante;

import java.util.List;

public interface AssuranceSanteServiceInt {
    void insertAssuranceSante (AssuranceSante assuranceSante);
    List<AssuranceSante> getAssuranceSanteByUserId(Long userId);
}
