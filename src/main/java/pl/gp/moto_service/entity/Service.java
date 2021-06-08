package pl.gp.moto_service.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull (message = "Enter the date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate serviceData;
    @NotBlank(message = "The actual mileage field cannot be empty")
    private int serviceMileage;
    @NotBlank(message = "The run interval field cannot be empty")
    private int runInterval;
    @NotBlank(message = "The time interval field cannot be empty")
    private int timeInterval;
    @NotBlank(message = "The service cost field cannot be empty")
    private long serviceCost;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Oil oil;

}
