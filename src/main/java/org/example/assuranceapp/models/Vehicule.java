package org.example.assuranceapp.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String marque;
    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<AssuranceAuto> assurances;

    public Vehicule() {}


    public Vehicule(String model, String marque, String type) {
        this.model = model;
        this.marque = marque;
        this.type = type;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<AssuranceAuto> getAssurances() {
        return assurances;
    }
    public void setAssurances(List<AssuranceAuto> assurances) {
        this.assurances = assurances;
    }

    }
