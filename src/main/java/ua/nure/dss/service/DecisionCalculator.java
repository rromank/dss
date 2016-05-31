package ua.nure.dss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.dss.domain.Alternative;
import ua.nure.dss.domain.Mark;
import ua.nure.dss.domain.Res;
import ua.nure.dss.repository.AlternativeRepository;
import ua.nure.dss.repository.CriterionRepository;
import ua.nure.dss.repository.MarkRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DecisionCalculator {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private AlternativeRepository alternativeRepository;

    @Autowired
    private CriterionRepository criterionRepository;

    public List<Res> calculateWeightedSum() {
        List<Res> results = new ArrayList<>();
        for (Alternative alternative : alternativeRepository.findAll()) {
            List<Mark> marks = alternative.getMarks();
            Res res = new Res();
            res.setAlternative(alternative);
            int generalMark = 0;
            for (Mark mark : marks) {
                generalMark += mark.getMark() * mark.getCriterion().getWeight();
            }
            res.setGeneralMark(generalMark);
            results.add(res);
        }
        return results;
    }

}