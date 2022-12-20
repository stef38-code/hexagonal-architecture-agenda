package org.hexagonal.architecture.agenda.infrastructure.mock;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.ListerPersonnePort;
import org.hexagonal.architecture.agenda.infrastructure.tools.JsonFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ListerPersonnePortMock implements ListerPersonnePort {
    static Logger logger = LoggerFactory.getLogger(ListerPersonnePortMock.class);



    @Override
    public List<Personne> lister() {
        Optional<File> json = JsonFile.getFile("mock/ListePersonnes.json");
        Optional<List<Personne>> personnes = JsonFile.parseJsonToObject(json, new TypeReference<List<Personne>>() {
        });
        return personnes.orElse(Collections.EMPTY_LIST);
    }


}
