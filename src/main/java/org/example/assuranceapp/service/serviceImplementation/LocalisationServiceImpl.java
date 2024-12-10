package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.LocalisationDaoInt;
import org.example.assuranceapp.models.Localisation;
import org.example.assuranceapp.service.serviceInterface.LocalisationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LocalisationServiceImpl implements LocalisationServiceInt {
    @Autowired
    private LocalisationDaoInt LocalisationDao;

    @Override
    public List<Localisation> getAllLocalisations() {
        return LocalisationDao.getAllLocalisations();
    }

    @Override
    public Localisation getLocalisationById(Long id) {
        return LocalisationDao.getLocalisationById(id);
    }
}
