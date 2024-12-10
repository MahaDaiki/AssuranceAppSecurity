package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.AssuranceAuto;

import java.util.List;

public interface AssuranceAutoServiceInt {
    void insertAssuranceAuto(AssuranceAuto assuranceAuto);
    List<AssuranceAuto> getAssurancesByUserId(Long userId);
}
