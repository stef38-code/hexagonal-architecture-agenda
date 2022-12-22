package org.hexagonal.architecture.agenda.infrastructure.entity;

import java.time.LocalDate;

public class PersonneEntity {
    private final String id;
    private final String nom;
    private final String prenom;
    private final LocalDate dateNaiss;

    public PersonneEntity(String id, String nom, String prenom, LocalDate dateNaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
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

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }
}
