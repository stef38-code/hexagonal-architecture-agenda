package org.hexagonal.architecture.agenda.domain.ports.inbound;

import org.hexagonal.architecture.agenda.domain.model.Personne;

import java.util.List;

public interface AjoutPersonneUseCase {
    Personne ajouter(Personne personne);
    List<Personne> ajouter(List<Personne> personnes);
}
