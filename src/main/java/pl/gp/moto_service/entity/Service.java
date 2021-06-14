package pl.gp.moto_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
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
    private double serviceCost;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Oil oil;

  /*  public Service(final int id, final String serviceType, final boolean isActiv, final LocalDate serviceData, final int serviceMileage, final int runInterval, final int timeInterval, final double quantity, final double serviceCost, final Vehicle vehicle, final Oil oil) {
    }
    public Service(){}*/
}
