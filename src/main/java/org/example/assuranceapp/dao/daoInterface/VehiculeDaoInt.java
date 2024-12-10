package org.example.assuranceapp.dao.daoInterface;

import org.example.assuranceapp.models.Vehicule;

import java.util.List;

public interface VehiculeDaoInt {
    List<Vehicule> getAllVehicules();
    Vehicule getVehiculeById(Long id);
}
