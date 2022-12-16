package step.definitions;

import java.time.LocalDate;

public class AjoutPersonneUseCaseParameter {
    private String nom;
    private String prenom;
    private LocalDate dNaiss;

    public AjoutPersonneUseCaseParameter(String nom, String prenom, LocalDate dNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.dNaiss = dNaiss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getdNaiss() {
        return dNaiss;
    }

    public void setdNaiss(LocalDate dNaiss) {
        this.dNaiss = dNaiss;
    }
}
