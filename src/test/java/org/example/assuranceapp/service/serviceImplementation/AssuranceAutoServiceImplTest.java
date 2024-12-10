package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.AssuranceAutoDaoInt;
import org.example.assuranceapp.models.AssuranceAuto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AssuranceAutoServiceImplTest {
    @Mock
    private AssuranceAutoDaoInt assuranceAutoDao;

    @InjectMocks
    private AssuranceAutoServiceImpl assuranceAutoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertAssuranceAuto_ValidInput() {
        AssuranceAuto assuranceAuto = new AssuranceAuto();
        assuranceAuto.setAgeConducteur(25);
        assuranceAuto.setUtilisationvehicule("Personnelle");

        assuranceAutoService.insertAssuranceAuto(assuranceAuto);

        verify(assuranceAutoDao, times(1)).insertAssuranceAuto(assuranceAuto);
    }

    @Test
    public void testInsertAssuranceAuto_InvalidAge_ThrowsException() {
        AssuranceAuto assuranceAuto = new AssuranceAuto();
        assuranceAuto.setAgeConducteur(-1);
        assuranceAuto.setUtilisationvehicule("Personnelle");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            assuranceAutoService.insertAssuranceAuto(assuranceAuto);
        });

        assertEquals("L'âge du conducteur ne peut pas être négatif ou zéro.", exception.getMessage());
        verify(assuranceAutoDao, never()).insertAssuranceAuto(any(AssuranceAuto.class));
    }

    @Test
    public void testInsertAssuranceAuto_EmptyUtilisationVehicule_ThrowsException() {
        AssuranceAuto assuranceAuto = new AssuranceAuto();
        assuranceAuto.setAgeConducteur(25);
        assuranceAuto.setUtilisationvehicule("");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            assuranceAutoService.insertAssuranceAuto(assuranceAuto);
        });

        assertEquals("L'utilisation du véhicule ne peut pas être vide.", exception.getMessage());
        verify(assuranceAutoDao, never()).insertAssuranceAuto(any(AssuranceAuto.class));
    }

    @Test
    public void testGetAssurancesByUserId_ValidUserId() {
        Long userId = 1L;

        List<AssuranceAuto> expectedAssurances = new ArrayList<>();
        expectedAssurances.add(new AssuranceAuto());

        when(assuranceAutoDao.getAssurancesByUserId(userId)).thenReturn(expectedAssurances);

        List<AssuranceAuto> result = assuranceAutoService.getAssurancesByUserId(userId);

        assertEquals(expectedAssurances, result);
        verify(assuranceAutoDao, times(1)).getAssurancesByUserId(userId);
    }

    @Test
    public void testGetAssurancesByUserId_EmptyResult() {
        Long userId = 1L;

        when(assuranceAutoDao.getAssurancesByUserId(userId)).thenReturn(new ArrayList<>());

        List<AssuranceAuto> result = assuranceAutoService.getAssurancesByUserId(userId);

        assertTrue(result.isEmpty());
        verify(assuranceAutoDao, times(1)).getAssurancesByUserId(userId);
    }

}