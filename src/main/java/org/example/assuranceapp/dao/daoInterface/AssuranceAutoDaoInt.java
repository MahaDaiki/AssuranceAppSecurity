package org.example.assuranceapp.dao.daoInterface;

import org.example.assuranceapp.models.Assurance;
import org.example.assuranceapp.models.AssuranceAuto;

import java.util.List;

public interface AssuranceAutoDaoInt {
    void insertAssuranceAuto(AssuranceAuto assuranceAuto);
    List<AssuranceAuto> getAssurancesByUserId(Long userId);

}
