package step.definitions.mocks;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.ListerPersonnePort;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ListerPersonnePortMock implements ListerPersonnePort {
    @Override
    public List<Personne> lister() {
        String pathname = getClass().getClassLoader().getResource("mock/ListePersonnes.json").getFile();
        File json = new File(pathname);
        try {
            return new ObjectMapper().readValue(json, new TypeReference<List<Personne>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
