package ua.nure.dss.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Criterion criterion;

    @Column
    private String name;

    @Column
    private Double range;

    @Column
    private Double numMark;

    @Column
    private Double normMark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    public Double getNumMark() {
        return numMark;
    }

    public void setNumMark(Double numMark) {
        this.numMark = numMark;
    }

    public Double getNormMark() {
        return normMark;
    }

    public void setNormMark(Double normMark) {
        this.normMark = normMark;
    }
}