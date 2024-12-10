package org.example.assuranceapp.models;


    import org.example.assuranceapp.enums.type_assurance;
    import org.example.assuranceapp.enums.type_logement;

    import javax.persistence.*;

    @Entity
    public class AssuranceHabitation extends Assurance {

        @Column(nullable = false)
        private double valeurBien;

        @Enumerated(EnumType.STRING)
        private type_logement typeLogement;

        private boolean systemeSecurite;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "localisation_id", referencedColumnName = "id")
        private Localisation localisation;


        public AssuranceHabitation() {
            super(type_assurance.habitation, 300, null);
        }


        public AssuranceHabitation(type_assurance type, int base, Utilisateur utilisateur, double valeurBien, type_logement typeLogement, boolean systemeSecurite, Localisation localisation) {
            super(type_assurance.habitation, 300, utilisateur);
            this.valeurBien = valeurBien;
            this.typeLogement = typeLogement;
            this.systemeSecurite = systemeSecurite;
            this.localisation = localisation;
        }

        public double getValeurBien() {
            return valeurBien;
        }
        public void setValeurBien(double valeurBien) {
            this.valeurBien = valeurBien;
        }
        public type_logement getTypeLogement() {
            return typeLogement;
        }
        public void setTypeLogement(type_logement typeLogement) {
            this.typeLogement = typeLogement;
        }
        public boolean isSystemeSecurite() {
            return systemeSecurite;
        }
        public void setSystemeSecurite(boolean systemeSecurite) {
            this.systemeSecurite = systemeSecurite;
        }
        public Localisation getLocalisation() {
            return localisation;
        }
        public void setLocalisation(Localisation localisation) {
            this.localisation = localisation;
        }


    }
