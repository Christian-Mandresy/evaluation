package com.vehicule.app.model;

import javax.persistence.*;

@Entity
@Table(name = "TypeVehicule")
public class TypeVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nom;

    @OneToOne(mappedBy = "typeVehicule")
    private Vehicule vehicule;

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

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
