package org.hexagonal.architecture.agenda.infrastructure.mock;


import com.fasterxml.jackson.core.type.TypeReference;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.ListerPersonnePort;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntity;
import org.hexagonal.architecture.agenda.infrastructure.mapper.PersonneEntityMapper;
import org.hexagonal.architecture.agenda.infrastructure.tools.JsonFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class ListerPersonnePortMock implements ListerPersonnePort {
    static Logger logger = LoggerFactory.getLogger(ListerPersonnePortMock.class);


    @Override
    public List<Personne> lister() {
        logger.info("Mock la liste des personnes en db");
        Optional<File> json = JsonFile.getFile("mock/ListePersonnes.json");
        Optional<List<PersonneEntity>> personnes = JsonFile.parseJsonToObject(json, new TypeReference<>() {
        });
        return PersonneEntityMapper.getInstance().to(personnes);
    }


}
