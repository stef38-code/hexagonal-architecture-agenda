package org.hexagonal.architecture.agenda.domain.ports.outbound;

import org.hexagonal.architecture.agenda.domain.model.Personne;

public interface AjoutPersonnePort {
    Personne ajouter(Personne personne);
}
