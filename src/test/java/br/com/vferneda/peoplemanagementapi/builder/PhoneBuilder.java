package br.com.vferneda.peoplemanagementapi.builder;

import br.com.vferneda.peoplemanagementapi.dto.request.PhoneDTO;
import br.com.vferneda.peoplemanagementapi.entity.Phone;
import br.com.vferneda.peoplemanagementapi.enums.PhoneType;

public class PhoneBuilder {

    private static final String PHONE_NUMBER = "4799100-2045";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

}
