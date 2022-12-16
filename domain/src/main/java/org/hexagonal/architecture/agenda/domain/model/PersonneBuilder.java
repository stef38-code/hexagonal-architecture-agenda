package org.hexagonal.architecture.agenda.domain.model;

import java.time.LocalDate;

public class PersonneBuilder implements PersonneStep, PersonneStep.Prenom,PersonneStep.Dnaiss,PersonneStep.Create{
    private String nom;
    private String prenom;
    private LocalDate dnaiss;

    @Override
    public PersonneBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    @Override
    public PersonneBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    @Override
    public PersonneBuilder dnaiss(LocalDate dnaiss) {
        this.dnaiss = dnaiss;
        return this;
    }

    @Override
    public Personne create() {
        return new Personne(nom,prenom,dnaiss);
    }
}
