package org.hexagonal.architecture.agenda.domain.ports.outbound;

import org.hexagonal.architecture.agenda.domain.model.Personne;

import java.util.List;

public interface ListerPersonnePort {
    List<Personne> lister();
}
