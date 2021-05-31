package pl.gp.moto_service.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tech_review")
public class TechReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Enter the date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseData;
    @DecimalMin(value = "1", message = "The price field cannot be zero")
    private double costs;

    @NotNull(message ="The vehicle field cannot be null" )
    @ManyToOne
    private Vehicle vehicle;

}
