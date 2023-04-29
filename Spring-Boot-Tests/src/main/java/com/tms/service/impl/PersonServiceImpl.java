package com.tms.service.impl;

import com.tms.client.AuthClient;
import com.tms.client.PersonClient;
import com.tms.domain.PersonEntity;
import com.tms.dto.PersonDto;
import com.tms.exc.UserNotValidException;
import com.tms.repository.PersonRepository;
import com.tms.service.PersonService;
import com.tms.service.PersonValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonValidatorService validator;

    private final PersonRepository repository;

    private final PersonClient personClient;

    private final AuthClient authClient;

    @Override
    public PersonDto save(PersonDto personDto) {
        if (validator.isValid(personDto)) {

            var personEntity = new PersonEntity();

            personEntity.setUsername(personDto.getUsername());
            personEntity.setPassword(personDto.getPassword());
            personEntity.setAge(personDto.getAge());

            PersonEntity save = repository.save(personEntity);

            return PersonDto.builder()
                    .username(save.getUsername())
                    .age(save.getAge())
                    .password(save.getPassword())
                    .build();
        }

        throw new UserNotValidException();
    }

    @Override
    public void saveByUsername(String username) {
        var personEntity = PersonEntity.builder()
                .username(username)
                .isAdmin(false)
                .build();

        if (username != null) {
            repository.save(personEntity);
        }

    }

    @Override
    public PersonEntity getByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public PersonDto getByUsername(String username) {
        authClient.validate();
        PersonDto personDto = personClient.validate();
        return new PersonDto(username, "123", false, 22);
    }
}
