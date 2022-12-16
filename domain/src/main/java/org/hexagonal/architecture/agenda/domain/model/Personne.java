package org.hexagonal.architecture.agenda.domain.model;

import java.time.LocalDate;

public class Personne {
    private final String id;
    private final String nom;
    private final String prenom;
    private final LocalDate dnaiss;

    Personne(String id,String nom, String prenom, LocalDate dnaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dnaiss = dnaiss;
    }

    public static PersonneStep aNew() {
        return new PersonneBuilder();
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

    public String getId() {
        return id;
    }
}
