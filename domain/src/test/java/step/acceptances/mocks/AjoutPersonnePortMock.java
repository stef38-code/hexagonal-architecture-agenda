package step.acceptances.mocks;

import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;

import java.util.UUID;

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
}
