package br.com.vferneda.peoplemanagementapi.builder;

import br.com.vferneda.peoplemanagementapi.dto.request.PeopleDTO;
import br.com.vferneda.peoplemanagementapi.entity.People;

import java.time.LocalDate;
import java.util.Collections;

public class PeopleBuilder {

    private static final String FIRST_NAME = "Vinicius";
    private static final String LAST_NAME = "Ferneda de Lima";
    private static final String CPF_NUMBER = "574.644.750-11";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1990, 3, 27);

    public static PeopleDTO createFakeDTO() {
        return PeopleDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("07-03-1994")
                .phones(Collections.singletonList(PhoneBuilder.createFakeDTO()))
                .build();
    }

    public static People createFakeEntity() {
        return People.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneBuilder.createFakeEntity()))
                .build();
    }

}
