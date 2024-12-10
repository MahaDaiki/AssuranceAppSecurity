package org.example.assuranceapp.dao.daoInterface;

import org.example.assuranceapp.models.Localisation;

import java.util.List;

public interface LocalisationDaoInt {
    public List<Localisation> getAllLocalisations();
    public Localisation getLocalisationById(Long id);
}
