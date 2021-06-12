package pl.gp.moto_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean archives = false;
    @NotBlank(message = "Pole Nazwa nie może być puste")
    private String name;
    @NotBlank(message = "Pole Model nie może być puste")
    private String model;
    @Size(min = 17, max = 17, message = "Numer VIN powinien zawierać 17 znaków")
    private String vin;
    @NotNull(message = "Wprowadź datę produkcji")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate productionData;
    @NotNull(message = "Wpradź datę rejestracji")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate purchaseData;
    @NotBlank(message = "Pole Numer rejestracyjny nie może być puste")
    private String registrationId;
    @Min(value = 0)
    private int mileage;
    @Min(value = 0)
    private int initialMileage;
    @Min(value = 0)
    private int operatingCosts;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.REMOVE)
    private List<TechReview> techReviews;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.REMOVE)
    private List<Insurance> insurances;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.REMOVE)
    private List<Service> services;


}
