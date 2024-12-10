package org.example.assuranceapp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String typeassurance;
    @Column(nullable = false)
    private double montant;
    @Column(nullable = false)
    private LocalDate datecreation;
    private boolean estAccepte;

    @OneToOne
    @JoinColumn(name = "assurance_id", referencedColumnName = "id")
    private Assurance assurance;

    public Devis() {}
    public Devis(String typeassurance, double montant, LocalDate datecreation, boolean estAccepte, Assurance assurance) {
        this.typeassurance = typeassurance;
        this.montant = montant;
        this.datecreation = datecreation;
        this.estAccepte = estAccepte;
        this.assurance = assurance;


    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTypeassurance() {
        return typeassurance;
    }
    public void setTypeassurance(String typeassurance) {
        this.typeassurance = typeassurance;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public LocalDate getDatecreation() {
        return datecreation;
    }
    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }
    public boolean isEstAccepte() {
        return estAccepte;
    }
    public void setEstAccepte(boolean estAccepte) {
        this.estAccepte = estAccepte;
    }
    public Assurance getAssurance() {
        return assurance;
    }
    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

}
