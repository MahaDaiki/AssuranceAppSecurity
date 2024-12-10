package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.VehiculeDaoInt;
import org.example.assuranceapp.models.Vehicule;
import org.example.assuranceapp.service.serviceInterface.VehiculeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class VehiculeServiceImpl implements VehiculeServiceInt {

    @Autowired
    private VehiculeDaoInt vehiculeDao;
    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeDao.getAllVehicules();
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return vehiculeDao.getVehiculeById(id);
    }
}
