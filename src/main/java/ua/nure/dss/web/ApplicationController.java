package ua.nure.dss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.nure.dss.domain.Alternative;
import ua.nure.dss.repository.HotelRepository;
import ua.nure.dss.service.DecisionCalculator;
import ua.nure.dss.ui.thymeleaf.annotation.Layout;

@Controller
@Layout("layouts/index")
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

    @RequestMapping("/decision")
    public ModelAndView openPage(@RequestParam(value = "step", required = false) Integer step,
                                 @RequestParam(value = "id", required = false) Long alternId){

        if (decisionCalculator.shouldCompareMore(step)){
            Alternative[] alts = decisionCalculator.getAlternativesToCompare(step, alternId);
            return new ModelAndView("decisionPage").addObject("first", alts[0]).addObject("second", alts[1]);
        }else{
            //todo get alt by id
//            return new ModelAndView("decisionResPage").addObject(bestDexision);
            return new ModelAndView("decisionResPage");
        }

    }
}