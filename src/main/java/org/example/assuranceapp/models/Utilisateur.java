package org.example.assuranceapp.models;


import javax.persistence.*;
import java.util.List;


@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nom;
    @Column(nullable = false)
    private String motdepasse;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private int telephone;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Assurance> assurances;

    public Utilisateur() {
    }
    public Utilisateur(String nom, String motdepasse, String adresse, String email, int telephone) {
        this.nom = nom;
        this.motdepasse = motdepasse;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMotdepasse() {
        return motdepasse;
    }
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
