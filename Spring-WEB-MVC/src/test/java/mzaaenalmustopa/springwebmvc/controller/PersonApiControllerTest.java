package mzaaenalmustopa.springwebmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mzaaenalmustopa.springwebmvc.model.CreatePersonRequest;
import mzaaenalmustopa.springwebmvc.model.CreateSocialMediaRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception{
        CreatePersonRequest createPerson = new CreatePersonRequest();
        createPerson.setFirstName("Muhamad");
        createPerson.setMiddleName("Zaenal");
        createPerson.setLastName("Mustopa");
        createPerson.setEmail("zaenal@gmail.com");
        createPerson.setPhone("09091010");
        createPerson.setHobbies(List.of("Coding","Reading","Gaming"));
        createPerson.setSocialMedia(new ArrayList<>());
        createPerson.getSocialMedia().add(new CreateSocialMediaRequest("Facebook", "facebook.com/zaenalebelmetal"));
        createPerson.getSocialMedia().add(new CreateSocialMediaRequest("Instagram", "instagram.com/zaenalebelmetal"));

        String jsonRequest = objectMapper.writeValueAsString(createPerson);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                content().json(jsonRequest)
        );
    }

    @Test
    void createPersonValidationError() throws Exception{
        CreatePersonRequest createPerson = new CreatePersonRequest();
        createPerson.setMiddleName("Zaenal");
        createPerson.setLastName("Mustopa");
        createPerson.setHobbies(List.of("Coding","Reading","Gaming"));
        createPerson.setSocialMedia(new ArrayList<>());
        createPerson.getSocialMedia().add(new CreateSocialMediaRequest("Facebook", "facebook.com/zaenalebelmetal"));
        createPerson.getSocialMedia().add(new CreateSocialMediaRequest("Instagram", "instagram.com/zaenalebelmetal"));

        String jsonRequest = objectMapper.writeValueAsString(createPerson);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Validation Error"))
        );
    }
}