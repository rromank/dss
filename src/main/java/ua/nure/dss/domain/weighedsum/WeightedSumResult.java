package ua.nure.dss.domain.weighedsum;

import ua.nure.dss.domain.Alternative;
import ua.nure.dss.domain.Criterion;
import ua.nure.dss.domain.Mark;

import java.util.ArrayList;
import java.util.List;

public class WeightedSumResult {

    private Alternative alternative;

    private Integer generalMark;

    private List<WeightMark> weightMarks = new ArrayList<>();

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public Integer getGeneralMark() {
        return generalMark;
    }

    public void setGeneralMark(Integer generalMark) {
        this.generalMark = generalMark;
    }

    public List<WeightMark> getWeightMarks() {
        return weightMarks;
    }

    public void setWeightMarks(List<WeightMark> weightMarks) {
        this.weightMarks = weightMarks;
    }

    public void addWeightMark(WeightMark weightMark) {
        weightMarks.add(weightMark);
    }
}