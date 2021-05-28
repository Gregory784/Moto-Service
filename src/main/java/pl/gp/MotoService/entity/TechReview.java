package pl.gp.MotoService.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tech_review")
public class TechReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseData;
    private double costs;

    public int getId() {
        return id;
    }

    public TechReview setId(final int id) {
        this.id = id;
        return this;
    }

    public LocalDate getReleaseData() {
        return releaseData;
    }

    public TechReview setReleaseData(final LocalDate releaseData) {
        this.releaseData = releaseData;
        return this;
    }

    public double getCosts() {
        return costs;
    }

    public TechReview setCosts(final double costs) {
        this.costs = costs;
        return this;
    }
}
