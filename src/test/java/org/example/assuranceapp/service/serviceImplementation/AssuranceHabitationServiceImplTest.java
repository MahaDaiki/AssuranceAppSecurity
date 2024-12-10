package org.example.assuranceapp.service.serviceImplementation;

import static org.junit.jupiter.api.Assertions.*;

import org.example.assuranceapp.dao.daoInterface.AssuranceHabitationDaoInt;
import org.example.assuranceapp.enums.type_logement;
import org.example.assuranceapp.models.AssuranceHabitation;
import org.example.assuranceapp.models.Localisation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AssuranceHabitationServiceImplTest {
    @Mock
    private AssuranceHabitationDaoInt assuranceHabitationDao;

    @InjectMocks
    private AssuranceHabitationServiceImpl assuranceHabitationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insertAssuranceHabitation_ShouldInsertSuccessfully_WhenValidInput() {

        AssuranceHabitation assuranceHabitation = new AssuranceHabitation();
        assuranceHabitation.setValeurBien(2000);
        assuranceHabitation.setTypeLogement(type_logement.appartement);
        assuranceHabitation.setLocalisation(new Localisation());

        doNothing().when(assuranceHabitationDao).insertAssuranceHabitation(assuranceHabitation);


        assuranceHabitationService.insertAssuranceHabitation(assuranceHabitation);


        verify(assuranceHabitationDao).insertAssuranceHabitation(assuranceHabitation);
    }

    @Test
    void insertAssuranceHabitation_ShouldThrowException_WhenValeurBienIsTooLow() {

        AssuranceHabitation assuranceHabitation = new AssuranceHabitation();
        assuranceHabitation.setValeurBien(500);


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                assuranceHabitationService.insertAssuranceHabitation(assuranceHabitation));

        assert (exception.getMessage().contains("Property value must be greater than 1000."));
    }

    @Test
    void insertAssuranceHabitation_ShouldThrowException_WhenTypeLogementIsNull() {

        AssuranceHabitation assuranceHabitation = new AssuranceHabitation();
        assuranceHabitation.setValeurBien(2000);
        assuranceHabitation.setTypeLogement(null);


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                assuranceHabitationService.insertAssuranceHabitation(assuranceHabitation));


        assert (exception.getMessage().contains("Type of logement must not be null."));
    }


    @Test
    void insertAssuranceHabitation_ShouldThrowException_WhenLocalisationIsNull() {

        AssuranceHabitation assuranceHabitation = new AssuranceHabitation();
        assuranceHabitation.setValeurBien(2000);
        assuranceHabitation.setTypeLogement(type_logement.maison);
        assuranceHabitation.setLocalisation(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                assuranceHabitationService.insertAssuranceHabitation(assuranceHabitation));


        assert (exception.getMessage().contains("Localisation must not be null."));
    }
}