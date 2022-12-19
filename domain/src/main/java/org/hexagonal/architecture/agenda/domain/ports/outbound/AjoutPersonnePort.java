package org.hexagonal.architecture.agenda.domain.ports.outbound;

import org.hexagonal.architecture.agenda.domain.model.Personne;

import java.util.List;

public interface AjoutPersonnePort {
    Personne ajouter(Personne personne);
    List<Personne> ajouter(List<Personne> personnes);
}
