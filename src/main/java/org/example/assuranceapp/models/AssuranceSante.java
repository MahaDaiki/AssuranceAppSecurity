package org.example.assuranceapp.models;

import org.example.assuranceapp.enums.type_assurance;
import org.example.assuranceapp.enums.type_de_couverture;

import javax.persistence.*;

@Entity
public class AssuranceSante extends Assurance {

    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String etatSante;



    @Enumerated(EnumType.STRING)
    private type_de_couverture typeDeCouverture;

    private boolean maladieChronique;
    public AssuranceSante() {
        super(type_assurance.sante, 150 , null);
    }


    public AssuranceSante(type_assurance type, int base, Utilisateur utilisateur, int age, String etatSante, type_de_couverture typeDeCouverture, boolean maladieChronique) {
        super(type_assurance.sante, 150 , utilisateur);
        this.age = age;
        this.etatSante = etatSante;
        this.typeDeCouverture = typeDeCouverture;
        this.maladieChronique = maladieChronique;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEtatSante() {
        return etatSante;
    }
    public void setEtatSante(String etatSante) {
        this.etatSante = etatSante;
    }
    public type_de_couverture getTypeDeCouverture() {
        return typeDeCouverture;
    }

    public boolean isMaladieChronique() {
        return maladieChronique;
    }
    public void setMaladieChronique(boolean maladieChronique) {
        this.maladieChronique = maladieChronique;
    }

    public type_de_couverture setTypeDeCouverture(type_de_couverture typeDeCouverture) {
        return typeDeCouverture;
    }

    }