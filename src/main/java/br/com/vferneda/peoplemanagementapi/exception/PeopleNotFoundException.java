package br.com.vferneda.peoplemanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeopleNotFoundException extends Exception {

    public PeopleNotFoundException(Long id) {
        super(String.format("Person with ID %s not found!", id));
    }

}
