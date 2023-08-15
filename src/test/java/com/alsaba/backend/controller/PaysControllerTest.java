package com.alsaba.backend.controller;

import com.alsaba.backend.model.Pays;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PaysController.class)
@TestMethodOrder(MethodOrderer.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PaysControllerTest {

    private Pays pays ;
    @BeforeAll
    void createPaysObject(){
        this.pays = new Pays(
                "Guinée" ,
                "1234" ,
                "FGF" ,
                "Conakry" ,
                1200 ,
                1455
        ) ;
    }

    @Autowired
    private MockMvc mvc ;
    @Test
    @Order(1)
    void createNewPays() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/pays")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(this.pays));
                ;
        MvcResult response = mvc.perform(request).andReturn();
        System.out.println(response.getResponse());
        //assertEquals(200 , response.getResponse().getStatus());
    }

    @Test
    @Order(2)
    void getAllPays()  {
    }

    @Test
    @Order(3)
    void getPaysById() {
    }

    @Test
    @Order(4)
    void updatePays() {
    }

    @Test
    @Order(5)
    void deletePays() {
    }
}