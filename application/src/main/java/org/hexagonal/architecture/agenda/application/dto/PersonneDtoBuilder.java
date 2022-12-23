package org.hexagonal.architecture.agenda.application.dto;

import java.time.LocalDate;

public final class PersonneDtoBuilder {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;

    private PersonneDtoBuilder() {
    }

    public static PersonneDtoBuilder aPersonneEntity() {
        return new PersonneDtoBuilder();
    }

    public PersonneDtoBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PersonneDtoBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneDtoBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneDtoBuilder dateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
        return this;
    }

    public PersonneDto build() {
        return new PersonneDto(id, nom, prenom, dateNaiss);
    }
}
