package br.com.vferneda.peoplemanagementapi.dto.mapper;

import br.com.vferneda.peoplemanagementapi.dto.request.PeopleDTO;
import br.com.vferneda.peoplemanagementapi.entity.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    People toModel(PeopleDTO dto);

    PeopleDTO toDTO(People dto);

}
