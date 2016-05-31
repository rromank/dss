package ua.nure.dss.domain;

import java.util.List;

/**
 * Created by Ihor on 31.05.2016.
 */
public class CompareEntity {

    private Alternative alternative;
    private List<Mark> marks;

    public CompareEntity(Alternative alternative, List<Mark> marks) {
        this.alternative = alternative;
        this.marks = marks;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
