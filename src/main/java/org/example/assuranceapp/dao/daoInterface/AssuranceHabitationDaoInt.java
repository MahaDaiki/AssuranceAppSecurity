package org.example.assuranceapp.dao.daoInterface;

import org.example.assuranceapp.models.AssuranceAuto;
import org.example.assuranceapp.models.AssuranceHabitation;

import java.util.List;

public interface AssuranceHabitationDaoInt  {
    void insertAssuranceHabitation (AssuranceHabitation assuranceHabitation);
    List<AssuranceHabitation> getHabitationAssuranceByUserId(Long userId);
}
