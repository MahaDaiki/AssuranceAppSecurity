package org.example.assuranceapp.models;

import org.example.assuranceapp.enums.type_assurance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private type_assurance type;
    @Column(nullable = false)
    private int base;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToOne(mappedBy = "assurance", cascade = CascadeType.ALL)
    private Devis devis;

    public Assurance() {}
    public Assurance(type_assurance type,  int base ,Utilisateur utilisateur) {
        this.type = type;
        this.base = base;
        this.utilisateur = utilisateur;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public type_assurance getType() {
        return type;
    }
    public void setType(type_assurance type) {
        this.type = type;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
     public int getBase() {
        return base;
     }
     public void setBase(int base) {
        this.base = base;
     }
     public Devis getDevis() {
        return devis;
     }
     public void setDevis(Devis devis) {
        this.devis = devis;
     }

    }


