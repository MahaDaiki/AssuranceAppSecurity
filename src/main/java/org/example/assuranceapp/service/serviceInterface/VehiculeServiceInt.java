package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.Vehicule;

import java.util.List;

public interface VehiculeServiceInt {
    List<Vehicule> getAllVehicules();
    Vehicule getVehiculeById(Long id);
}
