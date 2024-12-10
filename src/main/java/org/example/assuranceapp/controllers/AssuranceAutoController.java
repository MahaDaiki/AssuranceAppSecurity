package org.example.assuranceapp.controllers;

import org.example.assuranceapp.models.*;
import org.example.assuranceapp.service.serviceInterface.AssuranceAutoServiceInt;
import org.example.assuranceapp.service.serviceInterface.DevisServiceInt;
import org.example.assuranceapp.service.serviceInterface.VehiculeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/assuranceauto")
public class AssuranceAutoController {
    @Autowired
    private AssuranceAutoServiceInt assuranceAutoService;
    @Autowired
    private VehiculeServiceInt vehiculeService;
    @Autowired
    DevisServiceInt devisService;


    @GetMapping("/new")
    public ModelAndView showNewAssuranceForm(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        ModelAndView modelAndView = new ModelAndView("AssuranceAuto");
        modelAndView.addObject("assuranceAuto", new AssuranceAuto());

        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        modelAndView.addObject("vehicules", vehicules);

        return modelAndView;
    }

    @PostMapping("/createauto")
    public String createAssuranceAuto(@ModelAttribute AssuranceAuto assuranceAuto, HttpServletRequest request, @RequestParam("vehiculeId") Long vehiculeId) {
        HttpSession session = request.getSession(false);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            Vehicule vehicule = new Vehicule();
            vehicule.setId(vehiculeId);
            assuranceAuto.setVehicule(vehicule);
            assuranceAuto.setUtilisateur(utilisateur);
            assuranceAutoService.insertAssuranceAuto(assuranceAuto);

            Devis devis = devisService.calculeDevis(assuranceAuto);
            devisService.insertDevis(devis);

            session.setAttribute("generatedDevis", devis);
            return "redirect:/devis/display?message=Assurance created successfully!";
        } else {
            return "redirect:/auth/login?error=You need to log in to create an assurance!";
        }
    }

//    @GetMapping("/user/{userId}")
//    public ModelAndView getAssurancesByUserId(@PathVariable Long userId, HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            return new ModelAndView("redirect:/auth/login");
//        }
//
//        List<AssuranceAuto> assurances = assuranceAutoService.getAssurancesByUserId(userId);
//        ModelAndView modelAndView = new ModelAndView("assuranceList");
//        modelAndView.addObject("assurances", assurances);
//        return modelAndView;
//    }
}
