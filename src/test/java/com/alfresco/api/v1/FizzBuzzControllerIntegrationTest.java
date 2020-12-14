package com.alfresco.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFizzBuzzString() throws Exception {

        final String expectedValue = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz";
        final String expectedReport = "fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10";

        mockMvc.perform(get("/api/v1/fizz-buzz-values")
                .param("startNumber", "1")
                .param("endNumber", "20")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(expectedValue))
                .andExpect(jsonPath("$.report").value(expectedReport));
    }

    @Test
    public void getFizzBuzzString_wrongParam() throws Exception {

        final String expectedValue = "startNumber must be an integer";

        mockMvc.perform(get("/api/v1/fizz-buzz-values")
                .param("startNumber", "string")
                .param("endNumber", "20")
                .accept(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedValue));
    }
}
