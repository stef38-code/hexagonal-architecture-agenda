package org.hexagonal.architecture.agenda.infrastructure.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.hexagonal.architecture.agenda.domain.model.Personne;
import org.hexagonal.architecture.agenda.infrastructure.entity.PersonneEntity;
import org.hexagonal.architecture.agenda.infrastructure.exceptions.PeronneMapperException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;



public class PersonneEntityMapper {
    private static PersonneEntityMapper instance;

    private PersonneEntityMapper(){}

    public static synchronized PersonneEntityMapper getInstance() {
        if (instance == null) {
            instance = new PersonneEntityMapper();
        }
        return instance;
    }
    public Personne to(PersonneEntity entity){
        if (Objects.isNull(entity)) {
            throw new PeronneMapperException("Object is null");
        }
        return Personne.aNew()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .dnaiss(entity.getDateNaiss())
                .create();
    }
    public List<Personne> to(List<PersonneEntity> entities){
        if(CollectionUtils.isEmpty(entities)){
            throw new PeronneMapperException("Collection is null");
        }
        return entities.stream().map(this::to).collect(Collectors.toList());
    }

    public List<Personne> to(Optional<List<PersonneEntity>> optionalList) {
        List<PersonneEntity> personneEntities = optionalList.orElseThrow(() -> new PeronneMapperException("Optional is null"));
        return to(personneEntities);
    }
}
