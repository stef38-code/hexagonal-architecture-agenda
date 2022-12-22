package org.hexagonal.architecture.agenda.infrastructure.entity;

import java.time.LocalDate;

public final class PersonneEntityBuilder {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;

    private PersonneEntityBuilder() {
    }

    public static PersonneEntityBuilder aPersonneEntity() {
        return new PersonneEntityBuilder();
    }

    public PersonneEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PersonneEntityBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneEntityBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneEntityBuilder dateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
        return this;
    }

    public PersonneEntity build() {
        return new PersonneEntity(id, nom, prenom, dateNaiss);
    }
}
