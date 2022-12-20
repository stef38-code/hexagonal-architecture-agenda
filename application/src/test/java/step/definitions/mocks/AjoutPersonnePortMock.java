package step.definitions.mocks;

import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AjoutPersonnePortMock implements AjoutPersonnePort {
    @Override
    public Personne ajouter(Personne personne) {
        return Personne.aNew()
                .id(UUID.randomUUID().toString())
                .nom(personne.getNom())
                .prenom(personne.getPrenom())
                .dnaiss(personne.getDnaiss())
                .create();
    }

    @Override
    public List<Personne> ajouter(List<Personne> personnes) {
        return personnes.stream().map( personne -> Personne.aNew()
                .id(UUID.randomUUID().toString())
                .nom(personne.getNom())
                .prenom(personne.getPrenom())
                .dnaiss(personne.getDnaiss())
                .create()
        ).collect(Collectors.toList());
    }
}
