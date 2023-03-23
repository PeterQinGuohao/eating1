package Golf.springbootmongodb;

import Golf.springbootmongodb.controller.NoteController;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;




import Golf.springbootmongodb.model.NoteDTO;
import Golf.springbootmongodb.repository.NoteRepository;

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
import java.util.Date;

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
public class NoteControllerTest {


//    @Test
//    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
//            throws ClientProtocolException, IOException {
//
//        // Given
//        String name = RandomStringUtils.randomAlphabetic( 8 );
//        HttpUriRequest request = new HttpGet( "localhost:8080/notes");
//
//        // When
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
//
//        // Then
//        assertThat(
//                httpResponse.getStatusLine().getStatusCode(),
//                equalTo(HttpStatus.SC_NOT_FOUND));
//    }




    @Autowired
    private MockMvc mvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    private String newNoteId = new ObjectId().toString();
    private NoteDTO testNote= new NoteDTO(newNoteId, "63f42420f40edee1863e712c",
            "20130222","sunny day", "excellent weather!",new Date(System.currentTimeMillis()),null);
    private NoteRepository noteRepo;
    private final NoteController noteController = new NoteController();

    @Test
    void testCreateNote() throws Exception {
        String jsonString = objectMapper.writeValueAsString(testNote);
        mvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
        //ResponseEntity<?> test = noteController.createNote(testNote);
        //assertEquals(new ResponseEntity<>(testNote, HttpStatus.INTERNAL_SERVER_ERROR),test);

    }

    @Test
    void testGetAllNotes() throws Exception {
        mvc.perform(get("/notes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //ResponseEntity<?> test = NoteController.getAllNotes();
        //assertEquals(new ResponseEntity<>("No notes available", HttpStatus.NOT_FOUND),test);
    }

    @Test
    void testGetNoteById() throws Exception {
        //noteController.getNoteById("63fbe737bb588e4941adf8e9");
        mvc.perform(get("/notes/{id}","641bd33d7ceb5c2a6f1fb255")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        mvc.perform(get("/notes/{id}", "63fbe737bb588e4941adf8e9")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError());
    }

    @Test
    void testGetNoteByDailySummaryDate() throws Exception {
        //noteController.getNoteByDailySummaryDate("20130209");
        mvc.perform(get("/notes/dailySummaryDate/{dailySummaryDate}", "20130210")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        mvc.perform(get("/notes/dailySummaryDate/{dailySummaryDate}", "20130210")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError());
    }

    @Test
    void testUpdateNote() throws Exception {
        String updatedText = "{\"title\": \"boring\", \"text\": \"flight to Atlanta afternoon.\"}";
        mvc.perform(put("/notes/{id}", "63fbed6b74ee5d0843bc8f0a")
                        .contentType(MediaType.APPLICATION_JSON).content(updatedText))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteNote() throws Exception {
        mvc.perform(delete("/notes/{id}", newNoteId).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}

