package step.definitions;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AjoutPersonneUseCaseFeature {
    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public Book bookEntryTransformer(Map<String, String> row) {
        return new Book(
                row.get("title"),
                row.get("author"),
                Integer.parseInt(row.get("yearOfPublishing"))
        );
    }
    @Soit("l'utilisateur veut ajouter une personne avec les attributs suivants")
    public void l_utilisateur_veut_ajouter_une_personne_avec_les_attributs_suivants(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<AjoutPersonneUseCaseParameter> incomes = dataTable.asList(AjoutPersonneUseCaseParameter.class);
    }
    @Quand("l'utilisateur enregistre une nouvel personne")
    public void l_utilisateur_enregistre_une_nouvel_personne() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Alors("la nouvelle personne contient un id non null")
    public void la_nouvelle_personne_contient_un_id_non_null() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
