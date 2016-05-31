package ua.nure.dss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.dss.domain.Alternative;
import ua.nure.dss.domain.CompareEntity;
import ua.nure.dss.domain.Mark;
import ua.nure.dss.domain.weighedsum.WeightMark;
import ua.nure.dss.domain.weighedsum.WeightedSumResult;
import ua.nure.dss.repository.AlternativeRepository;
import ua.nure.dss.repository.CriterionRepository;
import ua.nure.dss.repository.MarkRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DecisionCalculator {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private AlternativeRepository alternativeRepository;

    @Autowired
    private CriterionRepository criterionRepository;

    public List<WeightedSumResult> calculateWeightedSum() {
        List<WeightedSumResult> results = new ArrayList<>();
        for (Alternative alternative : alternativeRepository.findAll()) {
            List<Mark> marks = alternative.getMarks();
            WeightedSumResult weightedSumResult = new WeightedSumResult();
            weightedSumResult.setAlternative(alternative);

            int generalMark = 0;
            for (Mark mark : marks) {
                Integer markValue = mark.getMark();
                Integer criterionWeight = mark.getCriterion().getWeight();
                generalMark += markValue * criterionWeight;
                WeightMark weightMark = new WeightMark();
                weightMark.setMark(markValue);
                weightMark.setWeight(criterionWeight);
                weightedSumResult.addWeightMark(weightMark);
            }
            weightedSumResult.setGeneralMark(generalMark);
            results.add(weightedSumResult);
        }
        return sort(results);
    }

    private List<WeightedSumResult> sort(List<WeightedSumResult> results) {
        return results.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getGeneralMark(), e1.getGeneralMark()))
                .collect(Collectors.toList());
    }

    public boolean shouldCompareMore(Integer step){
        return step == null || alternativeRepository.findAll().size() != step + 1;
    }

    public CompareEntity[] getAlternativesToCompare(Integer step, Long bestId){
        List<Alternative> alternatives = alternativeRepository.findAll();
        List<Mark> marks = markRepository.findAll();
        CompareEntity[] res = new CompareEntity[2];
        if (step == null){
            res[0] = new CompareEntity(alternatives.get(0), getMarks(alternatives.get(0), marks));
            res[1] = new CompareEntity(alternatives.get(1), getMarks(alternatives.get(1), marks));
        }else{
            res[1] = new CompareEntity(alternatives.get(step + 1), getMarks(alternatives.get(step + 1), marks));
            //todo get by id
            for (Alternative alt : alternatives){
                if (alt.getId().equals(bestId)){
                    res[0] = new CompareEntity(alt, getMarks(alt, marks));
                    break;
                }
            }
        }
        return res;
    }

    public CompareEntity getCompareEntity(Long altId){
        Alternative alt = alternativeRepository.findAll().stream().filter(a -> a.getId().equals(altId)).findFirst().get();
        return new CompareEntity(alt, getMarks(alt, markRepository.findAll()));
    }

    private List<Mark> getMarks(final Alternative alternative, List<Mark> marks){
        return marks.stream().filter(m -> m.getAlternative().equals(alternative)).collect(Collectors.toList());
    }

}