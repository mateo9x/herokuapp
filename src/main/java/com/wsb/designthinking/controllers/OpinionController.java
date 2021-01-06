package com.wsb.designthinking.controllers;

import com.wsb.designthinking.OpinionRepository;
import com.wsb.designthinking.model.Opinion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class OpinionController {

    private OpinionRepository opinionRepository;

    public OpinionController(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    @GetMapping("/rateUs")
    public String addOpinion(Model model, Opinion opinion){
        model.addAttribute("opinion", opinion);
        return "rate_us";
    }

    @GetMapping("/rateShow")
    public String showOpinions(Model model){
        model.addAttribute("opinion", opinionRepository.findAll());
        return "rate_show";
    }

    @PostMapping("/rateUs")
    public String saveOpinion(@Valid @ModelAttribute ("opinion") Opinion opinion, LocalDateTime dateTime, BindingResult result){

        if(result.hasErrors()){
            return "rate_us";
        }
        else {
            dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            opinion.setAddedTime(formattedDateTime);
            opinionRepository.save(opinion);
            return "redirect:/";
        }
    }
}
