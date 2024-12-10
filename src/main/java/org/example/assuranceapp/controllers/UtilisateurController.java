package org.example.assuranceapp.controllers;


import org.example.assuranceapp.models.AssuranceAuto;
import org.example.assuranceapp.models.AssuranceHabitation;
import org.example.assuranceapp.service.serviceInterface.AssuranceAutoServiceInt;
import org.example.assuranceapp.service.serviceInterface.AssuranceHabitationServiceInt;
import org.example.assuranceapp.service.serviceInterface.LocalisationServiceInt;
import org.example.assuranceapp.service.serviceInterface.VehiculeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class UtilisateurController {

    @Autowired
    private AssuranceHabitationServiceInt assuranceHabitationService;
    @Autowired
    private LocalisationServiceInt localisationService;
    @Autowired
    private AssuranceAutoServiceInt assuranceAutoService;
    @Autowired
    private VehiculeServiceInt vehiculeService;

    @GetMapping("/user")
    public ModelAndView getAssurancesByUserId(@PathVariable Long userId, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        List<AssuranceAuto> assurancesauto = assuranceAutoService.getAssurancesByUserId(userId);
        List<AssuranceHabitation> assuranceshabitation = assuranceHabitationService.getHabitationAssuranceByUserId(userId);
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("assurancehabitation", assuranceshabitation);
        modelAndView.addObject("assurancesauto", assurancesauto);
        return modelAndView;
    }
}
