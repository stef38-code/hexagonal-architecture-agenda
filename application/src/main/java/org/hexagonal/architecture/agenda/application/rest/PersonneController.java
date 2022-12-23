package org.hexagonal.architecture.agenda.application.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {
    @GetMapping(value = "/personnes")
    public ResponseEntity<Object> getProduct() {
        //return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
        return new ResponseEntity<>("Bonjour", HttpStatus.OK);
    }
}
