package org.example.assuranceapp.controllers;


import org.example.assuranceapp.models.Contrat;
import org.example.assuranceapp.models.Devis;
import org.example.assuranceapp.service.serviceInterface.DevisServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/devis")
public class DevisController {

    @Autowired
    DevisServiceInt devisService;

    @GetMapping("/display")
    public ModelAndView showGeneratedDevis(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        Devis generatedDevis = (Devis) session.getAttribute("generatedDevis");
        if (generatedDevis == null) {
            return new ModelAndView("redirect:/home?error=No devis generated!");
        }

        ModelAndView modelAndView = new ModelAndView("Devis");
        modelAndView.addObject("devis", generatedDevis);

        return modelAndView;
    }


    @PostMapping("/accept")
    public String acceptDevis(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Devis generatedDevis = (Devis) session.getAttribute("generatedDevis");

        if (generatedDevis != null) {

            generatedDevis.setEstAccepte(true);
            devisService.updateDevis(generatedDevis);


            session.removeAttribute("generatedDevis");
            Contrat contrat = new Contrat();
            contrat.setDateDebut(LocalDate.now());
            contrat.setDevis(generatedDevis);

            session.setAttribute("contrat", contrat);
            return "redirect:/contrat/generate?message=Devis accepted successfully!" ;


        }

        return "redirect:/home?error=No devis to accept!";
    }


    @PostMapping("/decline")
    public String declineDevis(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Devis generatedDevis = (Devis) session.getAttribute("generatedDevis");

        if (generatedDevis != null) {
            session.removeAttribute("generatedDevis");
            return "redirect:/home?message=Devis declined.";
        }

        return "redirect:/home?error=No devis to decline!";
    }

}
