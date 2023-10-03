package com.matthewa.openapidemo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMVC;

    private String encodeObjectAsJson(Object o) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(o);
    }

    @Test
    public void createAndGetEmployee() throws Exception {
        mockMVC.perform(
                post("/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(encodeObjectAsJson(new Employee(1111, "Johnny", "Chief Executive Officer", 10000)))) // "{ \"empId\": 0, \"name\": \"John\", \"designation\": \"CEO\", \"salary\": 1000000 }"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Johnny")));
        mockMVC.perform(
                get("/employees/1111")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Johnny")));
    }

    @Test
    public void createAndDeleteEmployee() throws Exception {
        mockMVC.perform(
                post("/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(encodeObjectAsJson(new Employee(1111, "Johnny", "Chief Executive Officer", 10000)))) // "{ \"empId\": 0, \"name\": \"John\", \"designation\": \"CEO\", \"salary\": 1000000 }"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Johnny")));
        mockMVC.perform(
                delete("/1111")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Johnny")));
    }
}
