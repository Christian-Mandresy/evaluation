package com.vehicule.app.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole nom;

  public Role() {

  }

  public Role(ERole name) {
    this.nom = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getName() {
    return nom;
  }

  public void setName(ERole name) {
    this.nom = name;
  }
}