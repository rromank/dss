package ua.nure.dss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ua.nure.dss.domain.Alternative;
import ua.nure.dss.domain.CompareEntity;
import ua.nure.dss.domain.VotingRes;
import ua.nure.dss.repository.AlternativeRepository;
import ua.nure.dss.repository.HotelRepository;
import ua.nure.dss.service.DecisionCalculator;
import ua.nure.dss.service.VotingService;

@Controller
public class ApplicationController {

    @Autowired
    private DecisionCalculator decisionCalculator;

    @Autowired
    private VotingService votingService;

    @Autowired
    private AlternativeRepository alternativeRepository;

    @RequestMapping("/")
    public String thymeleafIndexPage(Model model) {
        return "index";
    }

    @RequestMapping("/weighted-sum")
    public String calculateWeightedSum(Model model) {
        model.addAttribute("results", decisionCalculator.calculateWeightedSum());
        return "weightedSum";
    }

    @RequestMapping("/decision")
    public ModelAndView openPage(@RequestParam(value = "step", required = false) Integer step,
                                 @RequestParam(value = "id", required = false) Long alternId) {
        if (decisionCalculator.shouldCompareMore(step)) {
            CompareEntity[] alts = decisionCalculator.getAlternativesToCompare(step, alternId);
            return new ModelAndView("decisionPage").addObject("first", alts[0]).addObject("second", alts[1])
                    .addObject("step", step == null ? 1 : step + 1);
        } else {
            return new ModelAndView("decisionResPage").addObject("best", decisionCalculator.getCompareEntity(alternId));
        }
    }

    @RequestMapping("/bord_rule")
    public ModelAndView calculateByBord() {
        return new ModelAndView("bordPage").addObject("res", votingService.calculateByBord());
    }

    @RequestMapping("/kondorse_rule")
    public ModelAndView calculateByCondorse(){
        return new ModelAndView("kondorsePage").addObject("res", votingService.calculateByKondorse());
    }

    @RequestMapping("/koplend_rule")
    public ModelAndView calculateByKoplend(){
        return new ModelAndView("koplendPage").addObject("res", votingService.calculateByKoplend());
    }

}