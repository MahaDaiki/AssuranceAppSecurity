package org.example.assuranceapp.models;

import org.example.assuranceapp.enums.type_assurance;

import javax.persistence.*;
import java.util.List;


@Entity
public class AssuranceAuto extends Assurance {

    @Column(nullable = false)
    private int ageConducteur;
    @Column(nullable = false)
    private String Utilisationvehicule;
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;


    public AssuranceAuto() {
        super(type_assurance.automobile, 500, null);
    }

    public AssuranceAuto(type_assurance type, int base, Utilisateur utilisateur, int ageConducteur,String Utilisationvehicule  ,Vehicule vehicule) {
        super(type_assurance.automobile, 500 ,utilisateur);
        this.ageConducteur = ageConducteur;
        this.Utilisationvehicule = Utilisationvehicule;
        this.vehicule = vehicule;
    }
    public int getAgeConducteur() {
        return ageConducteur;
    }
    public void setAgeConducteur(int ageConducteur) {
        this.ageConducteur = ageConducteur;
    }
    public Vehicule getVehicule() {
        return vehicule;
    }
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    public String getUtilisationvehicule() {
        return Utilisationvehicule;
    }
    public void setUtilisationvehicule(String Utilisationvehicule) {
        this.Utilisationvehicule = Utilisationvehicule;
    }

public String toString(){
    return "AssuranceAuto{" +

            ", ageConducteur=" + ageConducteur +
            ", utilisationVehicule='" + Utilisationvehicule + '\'' +
            ", vehicule=" + (vehicule != null ? vehicule.getId() : "null") +
            ", utilisateur=" + (getUtilisateur() != null ? getUtilisateur().getId() : "null") +
            '}';
}

}