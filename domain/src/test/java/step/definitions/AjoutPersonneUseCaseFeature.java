package step.definitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.assertj.core.api.Assertions;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.inbound.AjoutPersonneUseCase;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;
import org.hexagonal.architecture.agenda.domain.services.AjoutPersonneService;
import step.acceptances.mocks.AjoutPersonnePortMock;

import java.time.LocalDate;
import java.util.Map;

public class AjoutPersonneUseCaseFeature {
    private Personne personne;
    private Personne actual;


    @DataTableType
    public Personne bookEntryTransformer(Map<String, String> row) {
        return Personne.aNew()
                .idNotDefine()
                .nom(row.get("nom"))
                .prenom(row.get("prenom"))
                .dnaiss(LocalDate.parse(row.get("dateNaiss")))
                .create();
    }
    @Soit("l'utilisateur veut ajouter une personne avec les attributs suivants")
    //public void l_utilisateur_veut_ajouter_une_personne_avec_les_attributs_suivants(DataTable dataTable) {
    public void l_utilisateur_veut_ajouter_une_personne_avec_les_attributs_suivants(Personne personne) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
       this.personne = personne;
    }
    @Quand("l'utilisateur enregistre une nouvel personne")
    public void l_utilisateur_enregistre_une_nouvel_personne() {
        AjoutPersonnePort personnePort = new AjoutPersonnePortMock();
        AjoutPersonneUseCase ajoutPersonneUseCase = new AjoutPersonneService(personnePort);
        this.actual = ajoutPersonneUseCase.ajouter(this.personne);
    }
    @Alors("la nouvelle personne contient un id non null")
    public void la_nouvelle_personne_contient_un_id_non_null() {
        Assertions.assertThat(this.actual.getId()).isNotBlank();
    }

}
