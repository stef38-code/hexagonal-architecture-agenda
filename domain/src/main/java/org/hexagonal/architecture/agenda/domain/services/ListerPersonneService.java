package org.hexagonal.architecture.agenda.domain.services;

import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.inbound.AjoutPersonneUseCase;
import org.hexagonal.architecture.agenda.domain.ports.inbound.ListerPersonneUseCase;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;
import org.hexagonal.architecture.agenda.domain.ports.outbound.ListerPersonnePort;

import java.util.List;

public class ListerPersonneService implements ListerPersonneUseCase {
    private final ListerPersonnePort personnePort;

    public ListerPersonneService(ListerPersonnePort personnePort) {
        this.personnePort = personnePort;
    }

    @Override
    public List<Personne> lister() {
        return personnePort.lister();
    }
}
