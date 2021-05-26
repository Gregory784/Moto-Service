package pl.gp.MotoService.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Pole Nazwa nie może być puste")
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseData;
    @NotBlank(message = "Pole Nazwa nie możę być puste")
    private String insuranceNumber;
    @DecimalMin(value = "0")
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

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseData=" + releaseData +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", costs=" + costs +
                '}';
    }
}
