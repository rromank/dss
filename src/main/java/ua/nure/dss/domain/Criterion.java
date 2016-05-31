package ua.nure.dss.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Criterion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    @Min(0)
    private Integer range;

    @Column
    @Min(0)
    @Max(5)
    private Integer weight;

    @Column
    @Enumerated(EnumType.STRING)
    private CriterionType criterionType;

    @Column
    @Enumerated(EnumType.STRING)
    private CriterionOptimType criterionOptimType;

    @Column
    private String unit;

    @Column
    private String scaleType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public CriterionType getCriterionType() {
        return criterionType;
    }

    public void setCriterionType(CriterionType criterionType) {
        this.criterionType = criterionType;
    }

    public CriterionOptimType getCriterionOptimType() {
        return criterionOptimType;
    }

    public void setCriterionOptimType(CriterionOptimType criterionOptimType) {
        this.criterionOptimType = criterionOptimType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getScaleType() {
        return scaleType;
    }

    public void setScaleType(String scaleType) {
        this.scaleType = scaleType;
    }
}