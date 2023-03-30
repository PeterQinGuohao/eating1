package Golf.springbootmongodb.controller;

import Golf.springbootmongodb.model.EatingDTO;
import Golf.springbootmongodb.repository.EatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EatingControllerWeb {

    @Autowired
    private EatingRepository eatingRepo;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World !!!";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/web/eating")
    public String eating(Model model) {
        List<EatingDTO> eating = eatingRepo.findAll();
        model.addAttribute("eatingList", eating);
        return "eating";
    }

    @PostMapping("/web/eating/save")
    public String saveEating(Model model,EatingDTO eating) {
        eatingRepo.save(eating);
        return "redirect:/web/eating";
    }
}
