package org.hexagonal.architecture.agenda.application.rest;

import org.hexagonal.architecture.agenda.application.services.ListPersonne;
import org.hexagonal.architecture.agenda.domain.ports.inbound.ListerPersonneUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(
        value = "personnes",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RestController
public class PersonneController {
    private final ListerPersonneUseCase listerPersonneUseCase;

    public PersonneController(ListerPersonneUseCase listerPersonneUseCase) {
        this.listerPersonneUseCase = listerPersonneUseCase;
    }

    @GetMapping(value = "/personnes")
    public ResponseEntity<Object> getProduct() {
        //return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
        return new ResponseEntity<>("Bonjour", HttpStatus.OK);
    }
}
