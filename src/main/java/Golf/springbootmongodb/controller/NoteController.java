package Golf.springbootmongodb.controller;

import Golf.springbootmongodb.model.NoteDTO;
import Golf.springbootmongodb.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    @Autowired
    private NoteRepository noteRepo;

    @GetMapping("/notes")
    public ResponseEntity<?> getAllNotes() {
        List<NoteDTO> notes = noteRepo.findAll();
        if (notes.size() > 0) {
            return new ResponseEntity<List<NoteDTO>>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No notes available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable("id") String id) {
        Optional<NoteDTO> noteOptional = noteRepo.findById(id);
        if (noteOptional.isPresent()) {
            return new ResponseEntity<>(noteOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Note not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/notes/dailySummaryDate/{dailySummaryDate}")
    public ResponseEntity<?> getNoteByDate(@PathVariable("dailySummaryDate") String dailySummaryDate) {
        List<NoteDTO> notes = noteRepo.findByDailySummaryDate(dailySummaryDate);
        if (notes.size() > 0) {
            return new ResponseEntity<List<NoteDTO>>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No notes available", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@RequestBody NoteDTO note){
        try {
            note.setCreatedAt(new Date(System.currentTimeMillis()));
            noteRepo.save(note);
            return new ResponseEntity<NoteDTO>(note, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
