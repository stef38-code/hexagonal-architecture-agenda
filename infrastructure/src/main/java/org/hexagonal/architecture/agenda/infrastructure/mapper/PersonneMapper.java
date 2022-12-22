package org.hexagonal.architecture.agenda.infrastructure.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntity;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntityBuilder;
import org.hexagonal.architecture.agenda.infrastructure.exceptions.PeronneMapperException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonneMapper {
    private static PersonneMapper instance;

    private PersonneMapper() {
    }

    public static synchronized PersonneMapper getInstance() {
        if (instance == null) {
            instance = new PersonneMapper();
        }
        return instance;
    }
    public PersonneEntity to(Personne personne){
        if (Objects.isNull(personne)) {
            throw new PeronneMapperException("Object is null");
        }
        return PersonneEntityBuilder.aPersonneEntity()
                .id(personne.getId())
                .nom(personne.getNom())
                .prenom(personne.getNom())
                .dateNaiss(personne.getDnaiss())
                .build();
    }
    public List<PersonneEntity> to(List<Personne> personnes){
        if(CollectionUtils.isEmpty(personnes)){
            throw new PeronneMapperException("Collection is null");
        }
        return personnes.stream().map(this::to).collect(Collectors.toList());
    }
}
