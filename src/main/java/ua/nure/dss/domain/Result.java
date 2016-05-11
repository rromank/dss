package ua.nure.dss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Lpr lpr;

    @ManyToOne
    private Alternative alternative;

    @Column
    private Double range;

    @Column
    private Double weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lpr getLpr() {
        return lpr;
    }

    public void setLpr(Lpr lpr) {
        this.lpr = lpr;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
