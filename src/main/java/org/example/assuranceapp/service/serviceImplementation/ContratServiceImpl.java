package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.ContratDaoInt;
import org.example.assuranceapp.models.Contrat;
import org.example.assuranceapp.service.serviceInterface.ContratServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContratServiceImpl implements ContratServiceInt {

    @Autowired
    ContratDaoInt contratDao;
    @Override
    public Contrat saveContrat(Contrat contrat) {
        return  contratDao.saveContrat(contrat);
    }

    @Override
    public void updateContrat(Contrat contrat) {
        contratDao.updateContrat(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        contratDao.deleteContrat(id);
    }

    @Override
    public Contrat findContratById(Long id) {
        return contratDao.findContratById(id);
    }
}
