package br.com.vferneda.peoplemanagementapi.service;

import br.com.vferneda.peoplemanagementapi.dto.mapper.PeopleMapper;
import br.com.vferneda.peoplemanagementapi.dto.request.PeopleDTO;
import br.com.vferneda.peoplemanagementapi.dto.response.MessageResponseDTO;
import br.com.vferneda.peoplemanagementapi.entity.People;
import br.com.vferneda.peoplemanagementapi.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.vferneda.peoplemanagementapi.builder.PeopleBuilder.createFakeDTO;
import static br.com.vferneda.peoplemanagementapi.builder.PeopleBuilder.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {

    @Mock
    private PeopleRepository peopleRepository;

    @Mock
    private PeopleMapper peopleMapper;

    @InjectMocks
    private PeopleService peopleService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PeopleDTO personDTO = createFakeDTO();
        People expectedSavedPerson = createFakeEntity();

        when(peopleMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(peopleRepository.save(any(People.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = peopleService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }
}
