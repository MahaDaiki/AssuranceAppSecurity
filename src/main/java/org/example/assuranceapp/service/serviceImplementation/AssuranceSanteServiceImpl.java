package org.example.assuranceapp.service.serviceImplementation;


import org.example.assuranceapp.dao.daoInterface.AssuranceSanteDaoInt;
import org.example.assuranceapp.models.AssuranceSante;
import org.example.assuranceapp.service.serviceInterface.AssuranceSanteServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AssuranceSanteServiceImpl implements AssuranceSanteServiceInt {

    @Autowired
    AssuranceSanteDaoInt assuranceSanteDao;

    @Override
    public void insertAssuranceSante(AssuranceSante assuranceSante) {
        assuranceSanteDao.insertAssuranceSante(assuranceSante);
    }

    @Override
    public List<AssuranceSante> getAssuranceSanteByUserId(Long userId) {
        return assuranceSanteDao.getAssuranceSanteByUserId(userId);
    }
}
