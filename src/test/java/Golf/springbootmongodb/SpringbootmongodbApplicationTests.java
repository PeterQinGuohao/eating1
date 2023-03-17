package Golf.springbootmongodb;

import Golf.springbootmongodb.controller.FitController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class SpringbootmongodbApplicationTests {
    @Autowired
    FitController fitController;
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(fitController).build();


    }

    @Test
    void contextGetByDate() throws Exception {
        MvcResult result = this.mockMvc.
                perform(get("/fit/getByDate?date=20130210")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertFalse(Objects.isNull(result));
    }


    @Test
    void contextGetCaloriesTotal() throws Exception {
        MvcResult result = this.mockMvc.
                perform(get("/fit/getCaloriesTotal?date=20130210")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertFalse(Objects.isNull(result));
    }

}
