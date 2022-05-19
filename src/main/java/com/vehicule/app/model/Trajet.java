package com.vehicule.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int id_vehicule;

    @Column
    private float quantite_carburant;

    @Column
    private float prix_carburant;

    @Column
    private String motif;

    @Column
    private int id_utilisateur;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_vehicule",insertable = false,updatable = false)
    private Vehicule vehicule;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_trajet")
    private Set<Situation> situation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public float getQuantite_carburant() {
        return quantite_carburant;
    }

    public void setQuantite_carburant(float quantite_carburant) {
        this.quantite_carburant = quantite_carburant;
    }

    public float getPrix_carburant() {
        return prix_carburant;
    }

    public void setPrix_carburant(float prix_carburant) {
        this.prix_carburant = prix_carburant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Set<Situation> getSituation() {
        return situation;
    }

    public void setSituation(Set<Situation> situation) {
        this.situation = situation;
    }
}
