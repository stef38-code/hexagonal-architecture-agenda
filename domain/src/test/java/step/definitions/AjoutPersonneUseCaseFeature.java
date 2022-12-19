package step.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.assertj.core.api.Assertions;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.inbound.AjoutPersonneUseCase;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;
import org.hexagonal.architecture.agenda.domain.services.AjoutPersonneService;
import step.definitions.mocks.AjoutPersonnePortMock;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AjoutPersonneUseCaseFeature {
    private Personne personne;
    private List<Personne> personnes;
    private Personne actual;
    private List<Personne> actualList;

    private AjoutPersonneUseCase ajoutPersonneUseCase;
    @DataTableType
    public Personne bookEntryTransformer(Map<String, String> row) {
        return Personne.aNew()
                .idNotDefine()
                .nom(row.get("nom"))
                .prenom(row.get("prenom"))
                .dnaiss(LocalDate.parse(row.get("dateNaiss")))
                .create();
    }
    @Before
    public void setUp() {
        //Mock de la base de données
        AjoutPersonnePort personnePort = new AjoutPersonnePortMock();
        //Utilisation du service
        ajoutPersonneUseCase = new AjoutPersonneService(personnePort);
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
        this.actual = ajoutPersonneUseCase.ajouter(this.personne);
    }
    @Alors("la nouvelle personne contient un id non null")
    public void la_nouvelle_personne_contient_un_id_non_null() {
        Assertions.assertThat(this.actual.getId()).isNotBlank();
    }
//////
@Soit("l'utilisateur veut ajouter plusieurs personnes avec les attributs suivants")
public void l_utilisateur_veut_ajouter_plusieurs_personnes_avec_les_attributs_suivants(List<Personne> personnes) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    this.personnes = personnes;
}
    @Quand("l'utilisateur enregistre la liste des personnes")
    public void l_utilisateur_enregistre_la_liste_des_personnes() {
        this.actualList = ajoutPersonneUseCase.ajouter(this.personnes);
    }
    @Alors("la liste des personnes non null")
    public void la_liste_des_personnes_non_null() {
        Assertions.assertThat(this.actualList).isNotEmpty();
    }
    @Alors("a un taille de {int}")
    public void a_un_taille_de(Integer int1) {
        Assertions.assertThat(this.actualList).hasSize(int1);
    }
    @Alors("chaque personne a un id non null")
    public void chaque_personne_a_un_id_non_null() {
        Assertions.assertThat(this.actualList).allSatisfy(personne -> Assertions.assertThat(personne.getId()).isNotEmpty());
    }
}
