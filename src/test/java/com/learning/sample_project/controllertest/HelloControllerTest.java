package com.learning.sample_project.controllertest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloEndPoint() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello"))
                .andExpect(status().isOk()) // Expect 200 OK status
                .andReturn();

        // Verify the response content
        String content = result.getResponse().getContentAsString();
        assertThat(content).isEqualTo("Hello World!");
    }
}
