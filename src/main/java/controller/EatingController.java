package controller;

import model.EatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.EatingRepository;

import java.util.List;

@RestController
public class EatingController {

    @Autowired
    private EatingRepository eatingRepo;

    @PostMapping("/eating")
    public ResponseEntity<?> createEating(@RequestBody EatingDTO eating){
        try {
            eating.setCalories(100);
            eatingRepo.save(eating);
            return new ResponseEntity<EatingDTO>(eating, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(eating, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/eating")
    public ResponseEntity<?> getAllEatings(){
        List<EatingDTO> eatings = eatingRepo.findAll();
        if(eatings.size()>0){
            return new ResponseEntity<List<EatingDTO>>(eatings, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No eatings find", HttpStatus.NOT_FOUND);
        }

    }

}
