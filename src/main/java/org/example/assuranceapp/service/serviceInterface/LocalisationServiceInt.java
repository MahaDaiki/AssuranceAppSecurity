package org.example.assuranceapp.service.serviceInterface;

import org.example.assuranceapp.models.Localisation;

import java.util.List;

public interface LocalisationServiceInt {
    public List<Localisation> getAllLocalisations();
    public Localisation getLocalisationById(Long id);
}
