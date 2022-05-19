package com.vehicule.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int id_trajet;

    @Column
    private boolean depart;

    @Column
    private Date date_heure;

    @Column
    private String lieu;

    @Column
    private Float kilometrage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public boolean isDepart() {
        return depart;
    }

    public void setDepart(boolean depart) {
        this.depart = depart;
    }

    public Date getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(Date date_heure) {
        this.date_heure = date_heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Float getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Float kilometrage) {
        this.kilometrage = kilometrage;
    }
}
