package org.hexagonal.architecture.agenda.application.services;

import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.ListerPersonnePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListerPersonneDefault  implements ListPersonne{
    @Override
    public List<Personne> lister() {
        return null;
    }
}
