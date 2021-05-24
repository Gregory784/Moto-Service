package pl.gp.MotoService.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate releaseData;
    private String insuranceNumber;
    private double costs;

    public int getId() {
        return id;
    }

    public Insurance setId(final int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Insurance setName(final String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleaseData() {
        return releaseData;
    }

    public Insurance setReleaseData(final LocalDate releaseData) {
        this.releaseData = releaseData;
        return this;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public Insurance setInsuranceNumber(final String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
        return this;
    }

    public double getCosts() {
        return costs;
    }

    public Insurance setCosts(final double costs) {
        this.costs = costs;
        return this;
    }
}
