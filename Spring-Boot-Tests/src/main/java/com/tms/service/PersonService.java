package com.tms.service;

import com.tms.domain.PersonEntity;
import com.tms.dto.PersonDto;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    void saveByUsername(String username);

    PersonEntity getByUsernameAndPassword(String username, String password);

    PersonDto getByUsername(String username);

}
