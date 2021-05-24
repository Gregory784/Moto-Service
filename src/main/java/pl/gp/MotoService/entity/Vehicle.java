package pl.gp.MotoService.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double id;
    private boolean archives;
    private String name;
    private String model;
    private int vin;
    private LocalDate productionData;
    private LocalDate purchaseData;
    private String registrationId;
    private int mileage;
    private int operatingCosts;

}
