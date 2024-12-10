package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.AssuranceHabitationDaoInt;
import org.example.assuranceapp.models.AssuranceHabitation;
import org.example.assuranceapp.service.serviceInterface.AssuranceHabitationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
@Service
public class AssuranceHabitationServiceImpl implements AssuranceHabitationServiceInt {

  @Autowired
  private AssuranceHabitationDaoInt assuranceHabitationDao;

    @Override
    public void insertAssuranceHabitation(AssuranceHabitation assuranceHabitation) {
        if (assuranceHabitation.getValeurBien() <= 1000) {
            throw new IllegalArgumentException("Property value must be greater than 1000.");
        }
        if (assuranceHabitation.getTypeLogement() == null) {
            throw new IllegalArgumentException("Type of logement must not be null.");
        }
        if (assuranceHabitation.getLocalisation() == null) {
            throw new IllegalArgumentException("Localisation must not be null.");
        }

        assuranceHabitationDao.insertAssuranceHabitation(assuranceHabitation);
    }

    @Override
    public List<AssuranceHabitation> getHabitationAssuranceByUserId(Long userId) {
        return assuranceHabitationDao.getHabitationAssuranceByUserId(userId);
    }
}
