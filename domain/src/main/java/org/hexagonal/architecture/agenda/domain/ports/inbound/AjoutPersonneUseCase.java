package org.hexagonal.architecture.agenda.domain.ports.inbound;

import org.hexagonal.architecture.agenda.domain.model.Personne;

public interface AjoutPersonneUseCase {
    Personne ajouter(Personne personne);
}
