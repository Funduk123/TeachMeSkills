package com.tms.repository;

import com.tms.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    PersonEntity findByUsernameAndPassword(String username, String password);

}
