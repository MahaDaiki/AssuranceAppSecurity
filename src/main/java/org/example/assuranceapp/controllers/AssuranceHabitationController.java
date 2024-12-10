package org.example.assuranceapp.controllers;


import org.example.assuranceapp.models.*;
import org.example.assuranceapp.service.serviceInterface.AssuranceHabitationServiceInt;
import org.example.assuranceapp.service.serviceInterface.DevisServiceInt;
import org.example.assuranceapp.service.serviceInterface.LocalisationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/assurancehabitation")
public class AssuranceHabitationController {
    @Autowired
    private AssuranceHabitationServiceInt assuranceHabitationService;
    @Autowired
    private LocalisationServiceInt localisationService;
    @Autowired
    DevisServiceInt devisService;

    @GetMapping("/new")
    public ModelAndView showNewAssuranceForm(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        ModelAndView modelAndView = new ModelAndView("AssuranceHabitation");
        modelAndView.addObject("assuranceHabitation", new AssuranceHabitation());


        List<Localisation> localisations = localisationService.getAllLocalisations();
        modelAndView.addObject("localisations", localisations);

        return modelAndView;
    }

    @PostMapping("/createhabitation")
    public String createHabitation(@ModelAttribute AssuranceHabitation assuranceHabitation,
                                   @RequestParam("localisationId") Long localisationId,
                                   HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            assuranceHabitation.setUtilisateur(utilisateur);
            Localisation localisation = new Localisation();
            localisation.setId(localisationId);
            assuranceHabitation.setLocalisation(localisation);

            assuranceHabitationService.insertAssuranceHabitation(assuranceHabitation);


            Devis devis = devisService.calculeDevis(assuranceHabitation);
            devisService.insertDevis(devis);

            session.setAttribute("generatedDevis", devis);

            return "redirect:/devis/display?message=Assurance created successfully!";
        } else {
            return "redirect:/auth/login?error=You need to log in to create an assurance!";
        }
    }
}
