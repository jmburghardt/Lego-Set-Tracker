package com.SetTracker.legosettracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("tracker")
public class LandingController {

    static ArrayList<String> sets =  new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("sets", sets);
        model.addAttribute("title", "Lego Set Tracker");
        return "tracker/index";
    }

    @RequestMapping(value = "addSet", method = RequestMethod.GET)
    public String displayAddSetForm(Model model){
        model.addAttribute("title", "Add A Set");
        return "tracker/addSet";
    }

    @RequestMapping(value = "addSet", method = RequestMethod.POST)
    public String processAddSetForm(@RequestParam String setName){
        sets.add(setName);
        return "redirect:";
    }
}
