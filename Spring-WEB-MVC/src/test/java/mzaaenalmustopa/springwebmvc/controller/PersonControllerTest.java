package mzaaenalmustopa.springwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName","Topa")
                        .param("middleName","Zaenal")
                        .param("lastName","Mustopa")
                        .param("email","zaenal@gmail.com")
                        .param("phone","09998880")
                        .param("address.street", "Jalan Belum Jadi")
                        .param("address.city","Jakarta")
                        .param("address.country","Indonesia")
                        .param("address.postalCode","46388")
                        .param("hobbies[0]","Coding")
                        .param("hobbies[1]","Reading")
                        .param("hobbies[2]","Gaming")
                        .param("socialMedia[0].name","Facebook")
                        .param("socialMedia[0].location","faacebook.com/zaenalebelmetal")
                        .param("socialMedia[1].name","Instagram")
                        .param("socialMedia[1].location","instagram.com/zaenalebelmetal")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Topa Zaenal Mustopa " +
                        "with email zaenal@gmail.com and phone 09998880 " +
                        "with address Jalan Belum Jadi, Jakarta, Indonesia, 46388"))
        );
    }

    @Test
    void createPersonValidationError () throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName","Zaenal")
                        .param("lastName","Mustopa")
                        .param("phone","09998880")
                        .param("address.street", "Jalan Belum Jadi")
                        .param("address.city","Jakarta")
                        .param("address.country","Indonesia")
                        .param("address.postalCode","46388")
                        .param("hobbies[0]","Coding")
                        .param("hobbies[1]","Reading")
                        .param("hobbies[2]","Gaming")
                        .param("socialMedia[0].name","Facebook")
                        .param("socialMedia[0].location","faacebook.com/zaenalebelmetal")
                        .param("socialMedia[1].name","Instagram")
                        .param("socialMedia[1].location","instagram.com/zaenalebelmetal")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid data"))
        );
    }
}