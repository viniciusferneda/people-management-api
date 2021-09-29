package br.com.vferneda.peoplemanagementapi.controller;

import br.com.vferneda.peoplemanagementapi.dto.request.PeopleDTO;
import br.com.vferneda.peoplemanagementapi.dto.response.MessageResponseDTO;
import br.com.vferneda.peoplemanagementapi.exception.PeopleNotFoundException;
import br.com.vferneda.peoplemanagementapi.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController {

    private final PeopleService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PeopleDTO peopleDTO) {
        return personService.create(peopleDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PeopleDTO findById(@PathVariable Long id) throws PeopleNotFoundException {
        return personService.findById(id);
    }

    @GetMapping
    public List<PeopleDTO> listAll() {
        return personService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PeopleDTO peopleDTO) throws PeopleNotFoundException {
        return personService.update(id, peopleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PeopleNotFoundException {
        personService.delete(id);
    }

}
