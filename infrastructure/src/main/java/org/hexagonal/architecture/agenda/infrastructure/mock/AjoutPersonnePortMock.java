package org.hexagonal.architecture.agenda.infrastructure.mock;

import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.domain.ports.outbound.AjoutPersonnePort;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntity;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntityBuilder;
import org.hexagonal.architecture.agenda.infrastructure.mapper.PersonneEntityMapper;
import org.hexagonal.architecture.agenda.infrastructure.mapper.PersonneMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AjoutPersonnePortMock implements AjoutPersonnePort {
    static Logger logger = LoggerFactory.getLogger(AjoutPersonnePortMock.class);
    @Override
    public Personne ajouter(Personne personne) {
        logger.info("Mock l'ajout d'une personne");
        PersonneEntity entity = PersonneMapper.getInstance().to(personne);
        PersonneEntity personneEntity = PersonneEntityBuilder.aPersonneEntity()
                .id(UUID.randomUUID().toString())
                .nom(entity.getNom())
                .prenom(entity.getNom())
                .dateNaiss(entity.getDateNaiss())
                .build();


        return PersonneEntityMapper.getInstance().to(personneEntity);
    }

    @Override
    public List<Personne> ajouter(List<Personne> personnes) {
        logger.info("Mock l'ajout d'une liste de personne");
        List<PersonneEntity> entities = PersonneMapper.getInstance().to(personnes);

        List<PersonneEntity> entityList = entities.stream().map(entity ->
                PersonneEntityBuilder.aPersonneEntity()
                        .id(UUID.randomUUID().toString())
                        .nom(entity.getNom())
                        .prenom(entity.getNom())
                        .dateNaiss(entity.getDateNaiss())
                        .build()
        ).collect(Collectors.toList());
        return PersonneEntityMapper.getInstance().to(entityList);
    }
}
