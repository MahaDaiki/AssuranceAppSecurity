package org.example.assuranceapp.models;

import javax.persistence.*;

@Entity
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String adresse;
    private boolean zoneRisques;

    public Localisation() {}


    public Localisation(String adresse, boolean zoneRisques) {
        this.adresse = adresse;
        this.zoneRisques = zoneRisques;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public boolean isZoneRisques() {
        return zoneRisques;
    }
    public void setZoneRisques(boolean zoneRisques) {
        this.zoneRisques = zoneRisques;
    }

}
