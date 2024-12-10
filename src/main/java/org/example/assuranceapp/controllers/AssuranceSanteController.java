package org.example.assuranceapp.controllers;


import org.example.assuranceapp.models.*;
import org.example.assuranceapp.service.serviceInterface.AssuranceSanteServiceInt;
import org.example.assuranceapp.service.serviceInterface.DevisServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/assurancesante")
public class AssuranceSanteController {


    @Autowired
    AssuranceSanteServiceInt assuranceSanteService;

    @Autowired
    DevisServiceInt devisService;

    @GetMapping("/new")
    public ModelAndView showNewAssuranceForm(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        ModelAndView modelAndView = new ModelAndView("AssuranceSante");
        modelAndView.addObject("assuranceSante", new AssuranceSante());

        return modelAndView;
    }

    @PostMapping("/createsante")
    public String createAssuranceAuto(@ModelAttribute AssuranceSante assurancesante, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            assurancesante.setUtilisateur(utilisateur);
            assuranceSanteService.insertAssuranceSante(assurancesante);

            Devis devis = devisService.calculeDevis(assurancesante);
            devisService.insertDevis(devis);

            session.setAttribute("generatedDevis", devis);
            return "redirect:/devis/display?message=Assurance created successfully!";
        } else {
            return "redirect:/auth/login?error=You need to log in to create an assurance!";
        }
    }

}
