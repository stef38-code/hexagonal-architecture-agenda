package org.hexagonal.architecture.agenda.domain.model;

import java.time.LocalDate;

class PersonneBuilder implements PersonneStep,PersonneStep.Nom, PersonneStep.Prenom,PersonneStep.Dnaiss,PersonneStep.Create{
    private String nom;
    private String prenom;
    private LocalDate dnaiss;
    private String id;

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
        return new Personne(id,nom,prenom,dnaiss);
    }

    @Override
    public PersonneBuilder id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public PersonneBuilder idNotDefine() {
        this.id = null;
        return this;
    }
}
