package com.tms.repository;

import com.tms.domain.PersonEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSaveGet() {

        // given
        var person = PersonEntity.builder()
                .username("test")
                .password("123")
                .build();

        // when
        personRepository.save(person);
        List<PersonEntity> all = personRepository.findAll();

        // then
        Assertions.assertThat(all).hasSize(1);

    }

    @Test
    public void testGetByUsernameAndPasswordExists() {

        // given
        var person = PersonEntity.builder()
                .username("test")
                .password("123")
                .build();

        // when
        personRepository.save(person);
        PersonEntity personFromDB = personRepository.findByUsernameAndPassword("test", "123");

        // then
        Assertions.assertThat(personFromDB).isNotNull();
        Assertions.assertThat(personFromDB.getId()).isNotNull();

    }

    @Test
    public void testGetByUsernameAndPasswordNotExists() {

        // given
        var person = PersonEntity.builder()
                .username("test")
                .password("123")
                .build();

        // when
        personRepository.save(person);

        PersonEntity personFromDB = personRepository.findByUsernameAndPassword("qwe", "123");

        List<PersonEntity> all = personRepository.findAll();

        // then
        Assertions.assertThat(personFromDB).isNull();
        Assertions.assertThat(all).hasSize(1);

    }

}