package org.example.assuranceapp.controllers;


import org.example.assuranceapp.models.Contrat;
import org.example.assuranceapp.service.serviceInterface.ContratServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratServiceInt contratService;

    @GetMapping("/generate")
    public String showContratForm(HttpSession session, Model model) {
        Contrat contrat = (Contrat) session.getAttribute("contrat");
        if (contrat != null) {
            model.addAttribute("contrat", contrat);
            return "Contrat";
        }
        return "redirect:/home?error=No contrat to display!";
    }

    @PostMapping("/save")
    public String saveContrat(
            @RequestParam("dateFin") LocalDate dateFin,
            @RequestParam("fichier") String fichier,
            HttpSession session) {

        Contrat contrat = (Contrat) session.getAttribute("contrat");
        if (contrat != null) {
            contrat.setDateFin(dateFin);
            contrat.setFichier(fichier);
            System.out.println(contrat);
            contratService.saveContrat(contrat);

            session.removeAttribute("contrat");
            return "redirect:/home?message=Contrat created successfully!";
        }
        return "redirect:/home?error=Failed to create contrat!";
    }
}
