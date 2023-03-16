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

    @PutMapping("/eating/{date}")
    public ResponseEntity<?> updateByDate(@PathVariable("date") String Date, @RequestBody EatingDTO eating) {
        Optional<EatingDTO> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(Date));
        if (eatingOptional.isPresent()) {
            EatingDTO preEating = eatingOptional.get();
            preEating.setCalories(eating.getCalories());
            preEating.setFood(eating.getFood() != null ? eating.getFood() : preEating.getFood());
            eatingRepo.save(preEating);
            return new ResponseEntity<>(preEating, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No eating find in that date", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eating/{date}")
    public ResponseEntity<?> deleteEatingByDate(@PathVariable("date") String Date) {
        try {
            EatingDTO eating = eatingRepo.findByDate(Date);
            //Optional<?> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(Date));
            eatingRepo.delete(eating);
            //eatingRepo.deleteByDate(Date);
            return new ResponseEntity<>("Successful delete with Date" + Date, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
