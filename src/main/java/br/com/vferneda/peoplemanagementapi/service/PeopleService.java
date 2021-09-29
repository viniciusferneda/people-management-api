package br.com.vferneda.peoplemanagementapi.service;

import br.com.vferneda.peoplemanagementapi.dto.mapper.PeopleMapper;
import br.com.vferneda.peoplemanagementapi.dto.request.PeopleDTO;
import br.com.vferneda.peoplemanagementapi.dto.response.MessageResponseDTO;
import br.com.vferneda.peoplemanagementapi.entity.People;
import br.com.vferneda.peoplemanagementapi.exception.PeopleNotFoundException;
import br.com.vferneda.peoplemanagementapi.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final PeopleMapper personMapper;

    public MessageResponseDTO create(PeopleDTO peopleDTO) {
        final People people = personMapper.toModel(peopleDTO);
        final People savedPeople = peopleRepository.save(people);
        return createMessageResponse("Person successfully created with ID ", savedPeople.getId());
    }

    public PeopleDTO findById(Long id) throws PeopleNotFoundException {
        final People people = peopleRepository.findById(id).orElseThrow(() -> new PeopleNotFoundException(id));
        return personMapper.toDTO(people);
    }

    public List<PeopleDTO> listAll() {
        final List<People> lPeople = peopleRepository.findAll();
        return lPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PeopleDTO personDTO) throws PeopleNotFoundException {
        peopleRepository.findById(id).orElseThrow(() -> new PeopleNotFoundException(id));

        final People updatedPeople = personMapper.toModel(personDTO);
        final People savedPeople = peopleRepository.save(updatedPeople);

        return createMessageResponse("Person successfully updated with ID ", savedPeople.getId());
    }

    public void delete(Long id) throws PeopleNotFoundException {
        peopleRepository.findById(id).orElseThrow(() -> new PeopleNotFoundException(id));
        peopleRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String msg, Long peopleId) {
        return MessageResponseDTO.builder()
                .message(msg + peopleId)
                .build();
    }

}
