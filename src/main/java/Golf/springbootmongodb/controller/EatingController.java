package Golf.springbootmongodb.controller;


import Golf.springbootmongodb.model.EatingDTO;
import Golf.springbootmongodb.repository.EatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Golf.springbootmongodb.model.EatingDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class EatingController {

    @Autowired
    private EatingRepository eatingRepo;

    @PostMapping("/eating")
    public ResponseEntity<?> createEating(@RequestBody EatingDTO eating) {
        try {
            eatingRepo.save(eating);
            return new ResponseEntity<EatingDTO>(eating, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(eating, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/eating")
    public ResponseEntity<?> getAllEatings() {
        List<EatingDTO> eatings = eatingRepo.findAll();
        if (eatings.size() > 0) {
            return new ResponseEntity<List<EatingDTO>>(eatings, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No eatings find", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/eating/{date}")
    public ResponseEntity<?> getEatingByDate(@PathVariable("date") String Date) {
        EatingDTO eating = eatingRepo.findByDate(Date);
        Optional<?> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(Date));
        if (eatingOptional.isPresent()) {
            return new ResponseEntity<>(eatingOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No eating find in that date", HttpStatus.NOT_FOUND);
        }

    }

}
