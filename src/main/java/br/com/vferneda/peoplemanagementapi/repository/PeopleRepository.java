package br.com.vferneda.peoplemanagementapi.repository;

import br.com.vferneda.peoplemanagementapi.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {

}
