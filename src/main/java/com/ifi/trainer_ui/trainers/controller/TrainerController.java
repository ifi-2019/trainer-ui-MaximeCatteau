package com.ifi.trainer_ui.trainers.controller;

import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrainerController {

    private TrainerService trainerService;

    @GetMapping(value = "/trainers")
    public ModelAndView trainers(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("trainers");
        mav.addObject("trainers", trainerService.listTrainers());
        return mav;
    }

    @GetMapping(value = "/profile")
    public ModelAndView profile(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("otherTrainers", trainerService.listTrainers());
        return mav;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService){
        this.trainerService = trainerService;
    }
}
