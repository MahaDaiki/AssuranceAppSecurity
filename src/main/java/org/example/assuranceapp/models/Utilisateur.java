package org.example.assuranceapp.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.assuranceapp.enums.Role;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Utilisateur() {
    }
    public Utilisateur(String nom, String motdepasse, String adresse, String email, int telephone, Role role) {
        this.nom = nom;
        this.motdepasse = motdepasse;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.role = role;
    }


}
