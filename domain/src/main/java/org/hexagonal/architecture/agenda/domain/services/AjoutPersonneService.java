package org.hexagonal.architecture.agenda.domain.services;

import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.inbound.AjoutPersonneUseCase;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;

import java.util.List;

public class AjoutPersonneService implements AjoutPersonneUseCase {
    private final AjoutPersonnePort personnePort;

    public AjoutPersonneService(AjoutPersonnePort personnePort) {
        this.personnePort = personnePort;
    }
    @Override
    public Personne ajouter(Personne personne){
        return  personnePort.ajouter(personne);
    }

    @Override
    public List<Personne> ajouter(List<Personne> personnes) {
        return  personnePort.ajouter(personnes);
    }
}
