package com.tms.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.dto.PersonDto;
import com.tms.service.PersonService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(value = PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    void testGetPersonIfNull() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/person"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();

        String viewName = modelAndView.getViewName();
        PersonDto person = (PersonDto) modelAndView.getModel().get("person");

        Assertions.assertThat(viewName).isEqualTo("person.html");
        Assertions.assertThat(person).isNull();

    }

    @Test
    void testGetPersonIfExists() throws Exception {

        var personDto = PersonDto.builder()
                .username("danila")
                .build();

        when(personService.save(any())).thenReturn(personDto);

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/person"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

        var modelAndView = mvcResult.getModelAndView();

        var viewName = modelAndView.getViewName();
        var person = (PersonDto) modelAndView.getModel().get("person");

        assertThat(viewName).isEqualTo("person.html");
        assertThat(person.getUsername()).isEqualTo("danila");

    }

    @Test
    @Disabled
    void testGetPersonIfThrow() throws Exception {

        var personDto = PersonDto.builder()
                .username("danila")
                .build();

        when(personService.save(any())).thenThrow(new RuntimeException());

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/person"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andReturn();

    }

    @Test
    void testGetById() throws Exception {

        var personDto = PersonDto.builder()
                .username("danila")
                .build();

        when(personService.save(any())).thenReturn(personDto);

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/person/getById")
                        .param("id", "test"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

    }

    @Test
    void testPostPerson() throws Exception {

        var personDto = PersonDto.builder()
                .username("danila")
                .password("12345")
                .isAdmin(true)
                .age(22)
                .build();

        when(personService.save(personDto)).thenReturn(personDto);

        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(personDto);

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(personJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

    }

}
