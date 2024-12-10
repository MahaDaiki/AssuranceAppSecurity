package org.example.assuranceapp.models;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Column(nullable = false)
    private String fichier;

    @OneToOne(optional = false)
    @JoinColumn(name = "devis_id", nullable = false, unique = true)
    private Devis devis;



    public Contrat() {}


    public Contrat(LocalDate dateDebut, LocalDate dateFin, String fichier, Devis devis) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.fichier = fichier;
        this.devis = devis;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public String getFichier() {
        return fichier;
    }
    public void setFichier(String fichier) {
        this.fichier = fichier;
    }
    public Devis getDevis() {
        return devis;
    }
    public void setDevis(Devis devis) {
        this.devis = devis;
    }

}
