package step.acceptances;

import io.cucumber.java.Before;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Sachantqu;
import org.assertj.core.api.Assertions;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.inbound.ListerPersonneUseCase;
import org.hexagonal.architecture.agenda.domain.ports.outbound.ListerPersonnePort;
import org.hexagonal.architecture.agenda.domain.services.ListerPersonneService;
import org.hexagonal.architecture.agenda.infrastructure.mock.ListerPersonnePortMock;

import java.util.List;

public class ListerPersonneUseCaseFeature {
    private List<Personne> personnes;

    private ListerPersonneUseCase listerPersonneUseCase;

    @Before
    public void setUp() {
        //Mock de la base de données
        ListerPersonnePort personnePort = new ListerPersonnePortMock();
        //Utilisation du service
        listerPersonneUseCase = new ListerPersonneService(personnePort);
    }

    @Sachantqu("il y a deja des personnes en base de donnees")
    public void il_y_a_deja_des_personnes_en_base_de_donnees() {
        System.out.println("-----------");
    }

    @Alors("Je veux voir la liste des personnes")
    public void je_veux_voir_la_liste_des_personnes() {
        personnes = listerPersonneUseCase.lister();
    }

    @Alors("la liste doit etre non vide")
    public void la_liste_doit_etre_non_vide() {
        Assertions.assertThat(personnes).isNotEmpty();
    }

    @Et("la liste a un taille de {int}")
    public void laListeAUnTailleDe(int taille) {
        Assertions.assertThat(personnes).hasSize(taille);
    }
}
