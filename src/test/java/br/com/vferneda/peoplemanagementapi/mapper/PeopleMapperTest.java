package br.com.vferneda.peoplemanagementapi.mapper;

import br.com.vferneda.peoplemanagementapi.builder.PeopleBuilder;
import br.com.vferneda.peoplemanagementapi.dto.mapper.PeopleMapper;
import br.com.vferneda.peoplemanagementapi.dto.request.PeopleDTO;
import br.com.vferneda.peoplemanagementapi.dto.request.PhoneDTO;
import br.com.vferneda.peoplemanagementapi.entity.People;
import br.com.vferneda.peoplemanagementapi.entity.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PeopleMapperTest {

    @Autowired
    private PeopleMapper peopleMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        final PeopleDTO peopleDTO = PeopleBuilder.createFakeDTO();
        final People people = peopleMapper.toModel(peopleDTO);

        assertEquals(peopleDTO.getFirstName(), people.getFirstName());
        assertEquals(peopleDTO.getLastName(), people.getLastName());
        assertEquals(peopleDTO.getCpf(), people.getCpf());

        Phone phone = people.getPhones().get(0);
        PhoneDTO phoneDTO = peopleDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        People people = PeopleBuilder.createFakeEntity();
        PeopleDTO peopleDTO = peopleMapper.toDTO(people);

        assertEquals(people.getFirstName(), peopleDTO.getFirstName());
        assertEquals(people.getLastName(), peopleDTO.getLastName());
        assertEquals(people.getCpf(), peopleDTO.getCpf());

        Phone phone = people.getPhones().get(0);
        PhoneDTO phoneDTO = peopleDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }

}
