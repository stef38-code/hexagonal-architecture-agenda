package org.hexagonal.architecture.agenda.infrastructure.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntity;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class JsonFileTest {

    @Test
    void parseJsonToObject() {
        Optional<File> json = JsonFile.getFile("mock/ListePersonnes.json");
        Optional<List<PersonneEntity>> personnes = JsonFile.parseJsonToObject(json, new TypeReference<>() {
        });
        assertThat (personnes).isPresent();
        assertThat(personnes.get()).isNotEmpty().hasSize(100);
    }
}
