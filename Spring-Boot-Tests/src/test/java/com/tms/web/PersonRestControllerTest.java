package com.tms.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.tms.dto.PersonDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"client.auth.url=127.0.0.1:9090"})
@AutoConfigureMockMvc
class PersonRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @RegisterExtension
    WireMockExtension wireMockExtension = WireMockExtension.newInstance()
            .options(WireMockConfiguration.options().port(9090))
            .build();

    @Test
    void getByUsername() throws Exception {

        PersonDto personDtoFromClient = PersonDto.builder()
                .age(23)
                .build();

        wireMockExtension.stubFor(WireMock.get("/validate_auth")
                .willReturn(WireMock.ok())
        );

        ObjectMapper objectMapper = new ObjectMapper();

        wireMockExtension.stubFor(WireMock.get("/validate_person")
                .willReturn(WireMock.ok().withBody(objectMapper.writeValueAsString(personDtoFromClient)))
        );

        String username = UUID.randomUUID().toString();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/rest").param("username", username))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        PersonDto personDto = objectMapper.readValue(contentAsString, PersonDto.class);

        Assertions.assertThat(personDto.getUsername()).isEqualTo(username);
        Assertions.assertThat(personDto.getPassword()).isEqualTo("123");
        Assertions.assertThat(personDto.isAdmin()).isEqualTo(false);
        Assertions.assertThat(personDto.getAge()).isEqualTo(22);
    }
}