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
import java.util.Optional;

@Controller
public class EatingControllerWeb {

    @Autowired
    private EatingRepository eatingRepo;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World !!!";
    }

    @GetMapping("/eatingAdd")
    public String add(Model model) {
        return "eatingAdd";
    }

    @GetMapping("/oneEating")
    public String getOne(Model model) {
        return "oneEating";
    }

    @GetMapping("/eatingUpdate")
    public String update(Model model) {
        return "eatingUpdate";
    }

    @GetMapping("/eatingDelete")
    public String delete(Model model) {
        return "eatingDelete";
    }

    @GetMapping("/web/eating")
    public String eating(Model model) {
        List<EatingDTO> eating = eatingRepo.findAll();
        model.addAttribute("eatingList", eating);
        return "eating";
    }

    @PostMapping("/web/eating/save")
    public String saveEating(Model model, EatingDTO eating) {
        //eatingRepo.save(eating);
        //return "redirect:/web/eating";
        Optional<?> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(eating.getDate()));
        if (eatingOptional.isPresent()) {
            return "dateExist";
        } else {
            eatingRepo.save(eating);
            return "redirect:/web/eating";
        }
    }

    @GetMapping("/web/eating/getDay")
    public String getByDate(Model model, String date) {
        Optional<?> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(date));
        if (eatingOptional.isPresent()) {
            EatingDTO eating = eatingRepo.findByDate(date);
            model.addAttribute("date", eating.getDate());
            model.addAttribute("calories", eating.getCalories());
            model.addAttribute("food", eating.getFood());
            return "getByDate";
        } else {
            return "blank";
        }
    }

    @PostMapping("/web/eating/update")
    public String updateEating(Model model, String datecheck,EatingDTO eating) {
        Optional<?> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(datecheck));
        if (eatingOptional.isPresent()) {
            EatingDTO preEating = eatingRepo.findByDate(datecheck);
            preEating.setCalories(eating.getCalories());
            preEating.setFood(eating.getFood() != null ? eating.getFood() : preEating.getFood());
            eatingRepo.save(preEating);
            return "redirect:/web/eating";
        } else {
            return "blank";
        }

    }

    @PostMapping("/web/eating/delete")
    public String deleteEating(Model model, String date) {
        Optional<?> eatingOptional = Optional.ofNullable(eatingRepo.findByDate(date));
        if (eatingOptional.isPresent()) {
            EatingDTO eating = eatingRepo.findByDate(date);
            eatingRepo.delete(eating);
            return "redirect:/web/eating";
        } else {
            return "blank";
        }
    }
}
