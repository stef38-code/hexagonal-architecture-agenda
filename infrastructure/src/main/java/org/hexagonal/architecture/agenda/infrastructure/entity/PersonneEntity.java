package org.hexagonal.architecture.agenda.infrastructure.entity;

import java.time.LocalDate;

public class PersonneEntity {
    private  String id;
    private String nom;
    private  String prenom;
    private  LocalDate dnaiss;

    public PersonneEntity() {
    }

    public PersonneEntity(String id, String nom, String prenom, LocalDate dnaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dnaiss = dnaiss;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDnaiss() {
        return dnaiss;
    }
}
