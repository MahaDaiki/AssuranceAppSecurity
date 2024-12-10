package org.example.assuranceapp.dao.daoInterface;


import org.example.assuranceapp.models.AssuranceSante;

import java.util.List;

public interface AssuranceSanteDaoInt {


    void insertAssuranceSante (AssuranceSante assuranceSante);
    List<AssuranceSante> getAssuranceSanteByUserId(Long userId);
}
