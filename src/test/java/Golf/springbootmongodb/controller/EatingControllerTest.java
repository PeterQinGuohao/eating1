package Golf.springbootmongodb.controller;

import Golf.springbootmongodb.model.EatingDTO;
import Golf.springbootmongodb.repository.EatingRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class EatingControllerTest {
    @Autowired
    private MockMvc mvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private EatingDTO testEating = new EatingDTO("123", "20230221", 1000, "rice");
    private EatingDTO testEating2 = new EatingDTO("123", "20230221", 1002, "rice2");
    private EatingRepository eatingRepo;
    private final EatingController eatingController = new EatingController();

    @Test
    void createEating() throws Exception {
        String jsonString = objectMapper.writeValueAsString(testEating);
        mvc.perform(post("/eating")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
        //ResponseEntity<?> test = eatingController.createEating(testEating);
        //assertEquals(new ResponseEntity<>(testEating, HttpStatus.INTERNAL_SERVER_ERROR),test);

    }

    @Test
    void getAllEatings() throws Exception {
        mvc.perform(get("/eating").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //ResponseEntity<?> test = eatingController.getAllEatings();
        //assertEquals(new ResponseEntity<>("No eatings find", HttpStatus.NOT_FOUND),test);
    }

    @Test
    void getEatingByDate() throws Exception {
        //eatingController.getEatingByDate("202302023");
        mvc.perform(get("/eating/{date}", "20230221")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/eating/{date}", "20230230")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void updateByDate() throws Exception {
        String jsonString = objectMapper.writeValueAsString(testEating);
        System.out.println(jsonString);
        String jsonString2 = "{\"calories\": 1003, \"food\":\"rice4\"}";
        System.out.println(jsonString2);
        mvc.perform(put("/eating/{date}", "20230221")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString2))
                .andExpect(status().isOk());
    }

    @Test
    void deleteEatingByDate() throws Exception {
        String jsonString = objectMapper.writeValueAsString(testEating);
        mvc.perform(post("/eating")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
        mvc.perform(delete("/eating/{date}", "20230221").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}