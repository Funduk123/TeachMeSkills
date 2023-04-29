package com.tms.service.impl;

import com.tms.domain.PersonEntity;
import com.tms.dto.PersonDto;
import com.tms.exc.UserNotValidException;
import com.tms.repository.PersonRepository;
import com.tms.service.PersonService;
import com.tms.service.PersonValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

    @Mock
    private PersonValidatorService validatorService;

    @Mock
    private PersonRepository personRepository;

    private PersonService service;

    //    // Один раз перед всеми тестами
//    @BeforeAll
//    public static void beforeAll() {
//        System.out.println("---------------- BEFORE All ----------------");
//    }
//
//    // Один раз после всех тестов
//    @AfterAll
//    public static void afterAll() {
//        System.out.println("---------------- AFTER All ----------------");
//    }

    // Перед каждым тестом
    @BeforeEach
    public void beforeEach() {
//        validatorService = Mockito.mock(PersonValidatorService.class);
//        personRepository = Mockito.mock(PersonRepository.class);
//
        service = new PersonServiceImpl(validatorService, personRepository, null, null);
    }

//    // После каждого теста
//    @AfterEach
//    public void afterEach() {
//        System.out.println("---------------- AFTER EACH ----------------");
//    }


    @Test
//    @RepeatedTest(value = 5)   // Запуск теста 5 раз
    public void saveSuccess() {

        // given

        var person = PersonDto.builder()
                .username("test")
                .password("123")
                .age(22)
                .build();

        Mockito.when(validatorService.isValid(person)).thenReturn(true);

        Mockito.when(personRepository.save(any()))
                .thenReturn(PersonEntity.builder()
                        .username("TEST")
                        .password("123")
                        .age(22)
                        .build());

        // when

        var save = service.save(person);

        // then

        assertNotNull(save);

        assertAll(() -> assertEquals("TEST", save.getUsername(), "username is not equals"),
                () -> assertEquals("123", save.getPassword(), "password is not equals"),
                () -> assertEquals(22, save.getAge(), "age is not equals"));

    }

    @Test
    public void savePersonIsNotValid() {

        // given

        var person = PersonDto.builder()
                .username("test")
                .password("123")
                .age(22)
                .build();

        Mockito.when(validatorService.isValid(person)).thenReturn(false);

        // when and then

        assertThrows(UserNotValidException.class, () -> service.save(person));

    }

//    @Test
////    @Disabled  // Отключить тест
//    public void personIsNull() {
//
//        // given
//
//        PersonDto person = null;
//
//        // when and then
//
//        assertThrows(UserNotValidException.class, () -> service.save(person));
//
//    }

    @Test
    public void testSaveByUsernameStoreInDb() {
        service.saveByUsername("test");
        Mockito.verify(personRepository, Mockito.only()).save(any());
    }

    @Test
    public void testSaveByUsernameWithRole() {

        // given
        var captor = ArgumentCaptor.forClass(PersonEntity.class);
        String username = "test";

        // when
        service.saveByUsername(username);

        // then
        Mockito.verify(personRepository).save(captor.capture());
        var value = captor.getValue();
        assertFalse(value.isAdmin());

    }

    @Test
    public void testNoSavedIfUsernameIsNull() {
        service.saveByUsername(null);
        Mockito.verifyNoInteractions(personRepository);
    }

    @Test
    public void getAdminByUsername() {
        var username = "admin";
        var password = "pass";
        Mockito.when(personRepository.findByUsernameAndPassword(Mockito.eq(username), anyString())).thenReturn(new PersonEntity());
        var personEntity = service.getByUsernameAndPassword(username, password);
    }



}