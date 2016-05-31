package ua.nure.dss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.dss.repository.HotelRepository;
import ua.nure.dss.service.DecisionCalculator;

@Controller
public class ApplicationController {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private DecisionCalculator decisionCalculator;

    @RequestMapping("/")
    public String thymeleafIndexPage(Model model) {
        model.addAttribute("hotels", hotelRepository.findAll());
        return "index";
    }

    @RequestMapping("/weighted-sum")
    public String calculateWeightedSum(Model model) {
        model.addAttribute("results", decisionCalculator.calculateWeightedSum());
        return "weightedSum";
    }
}