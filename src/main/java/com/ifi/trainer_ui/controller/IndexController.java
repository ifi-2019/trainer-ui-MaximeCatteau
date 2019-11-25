package com.ifi.trainer_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @PostMapping (value = "/registerTrainer")
    public ModelAndView registerNewTrainer(String trainerName){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("name", trainerName);
        return mav;
    }
}
