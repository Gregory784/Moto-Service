package pl.gp.moto_service.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "The name field cannot be empty")
    private String serviceType;
    private boolean active = true;

    @NotNull(message = "Enter the date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate serviceData;
    @Min(0)
    private int serviceMileage;
    @Min(0)
    private int runInterval;
    @Min(0)
    private int timeInterval;
    @Min(0)
    private double quantity;
    @DecimalMin("0")
    private long serviceCost;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Oil oil;

}
