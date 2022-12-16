package org.hexagonal.architecture.agenda.domain.model;

import java.time.LocalDate;

public interface PersonneStep {
    Nom id(String id);
    Nom idNotDefine();
    interface Nom{
        Prenom nom(String nom);
    }


    interface Prenom{
        Dnaiss prenom(String prenom);
    }
    interface Dnaiss{
        Create dnaiss(LocalDate dnaiss);
    }
    interface Create {
        Personne create();
    }
}
