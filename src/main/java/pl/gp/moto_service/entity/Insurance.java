package pl.gp.moto_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "The name field cannot be empty")
    private String name;
    @NotNull(message = "Enter the date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseData;
    @NotBlank(message = "The policy number field cannot be empty")
    private String insuranceNumber;

    @DecimalMin(value = "1", message = "The price field cannot be zero")
    private double costs;

    @NotNull(message ="The vehicle field cannot be null" )
    @ManyToOne
    private Vehicle vehicle;
}
