package org.hexagonal.architecture.agenda.domain.model;

import java.time.LocalDate;

public class Personne {
    private final String nom;
    private final String prenom;
    private final LocalDate dnaiss;

    Personne(String nom, String prenom, LocalDate dnaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.dnaiss = dnaiss;
    }

    public static PersonneStep aNew(){
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
}
