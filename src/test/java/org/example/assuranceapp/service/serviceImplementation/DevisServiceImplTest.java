package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.DevisDaoInt;
import org.example.assuranceapp.enums.type_de_couverture;
import org.example.assuranceapp.enums.type_logement;
import org.example.assuranceapp.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class DevisServiceImplTest {

    @Mock
    private DevisDaoInt devisDao;

    @InjectMocks
    private DevisServiceImpl devisService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertDevis() {
        Devis devis = new Devis();
        devisService.insertDevis(devis);
        verify(devisDao, times(1)).insertDevis(devis);
    }

    @Test
    public void testGetDevisById() {
        Devis devis = new Devis();
        when(devisDao.getDevisById(1)).thenReturn(devis);
        Devis result = devisService.getDevisById(1);
        assertNotNull(result);
        assertEquals(devis, result);
    }

    @Test
    public void testGetAllDevis() {
        List<Devis> devisList = Arrays.asList(new Devis(), new Devis());
        when(devisDao.getAllDevis()).thenReturn(devisList);
        List<Devis> result = devisService.getAllDevis();
        assertEquals(devisList.size(), result.size());
    }

    @Test
    public void testUpdateDevis() {
        Devis devis = new Devis();
        devisService.updateDevis(devis);
        verify(devisDao, times(1)).updateDevis(devis);
    }


}
