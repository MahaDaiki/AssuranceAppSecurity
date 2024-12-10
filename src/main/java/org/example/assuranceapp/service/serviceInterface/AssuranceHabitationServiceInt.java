package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.AssuranceHabitation;

import java.util.List;

public interface AssuranceHabitationServiceInt {
    void insertAssuranceHabitation (AssuranceHabitation assuranceHabitation);
    List<AssuranceHabitation> getHabitationAssuranceByUserId(Long userId);
}
