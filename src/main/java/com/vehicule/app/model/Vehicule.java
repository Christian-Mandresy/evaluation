package com.vehicule.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String numero;

    @Column
    private String marque;

    @Column
    private String modele;

    @Column
    @JoinColumn(insertable = false, updatable = false)
    private int id_type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type", referencedColumnName = "id", insertable = false,updatable = false)
    private TypeVehicule typeVehicule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return modele;
    }

    public void setModel(String model) {
        this.modele = model;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }
}
