package pl.gp.MotoService.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean archives = false;
    @NotBlank(message = "Pole Nazwa nie może być puste")
    private String name;
    @NotBlank (message = "Pole Model nie może być puste")
    private String model;
    @Size(min = 17, max = 17, message = "Numer VIN powinien zawierać 17 znaków")
    private String vin;
    @NotNull (message = "Wprowadź datę produkcji")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate productionData;
    @NotNull(message = "Wpradź datę rejestracji")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate purchaseData;
    @NotBlank(message = "Pole Numer rejestracyjny nie może być puste")
    private String registrationId;
    @DecimalMin(value = "0")
    private int mileage;
    @DecimalMin(value = "0")
    private int operatingCosts;

    @OneToOne(cascade = CascadeType.ALL)
    private Insurance insurance;

    @OneToOne(cascade = CascadeType.ALL)
    private TechReview techReview;

    public Vehicle(final int id, final boolean archives, final String name, final String model, final String vin, final LocalDate productionData, final LocalDate purchaseData, final String registrationId, final int mileage, final int operatingCosts, final Insurance insurance, final TechReview techReview) {
        this.id = id;
        this.archives = archives;
        this.name = name;
        this.model = model;
        this.vin = vin;
        this.productionData = productionData;
        this.purchaseData = purchaseData;
        this.registrationId = registrationId;
        this.mileage = mileage;
        this.operatingCosts = operatingCosts;
        this.insurance = insurance;
        this.techReview = techReview;
    }

    public Vehicle() {}

    public int getId() {
        return id;
    }

    public Vehicle setId(final int id) {
        this.id = id;
        return this;
    }

    public boolean isArchives() {
        return archives;
    }

    public Vehicle setArchives(final boolean archives) {
        this.archives = archives;
        return this;
    }

    public String getName() {
        return name;
    }

    public Vehicle setName(final String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(final String model) {
        this.model = model;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public Vehicle setVin(final String vin) {
        this.vin = vin;
        return this;
    }

    public LocalDate getProductionData() {
        return productionData;
    }

    public Vehicle setProductionData(final LocalDate productionData) {
        this.productionData = productionData;
        return this;
    }

    public LocalDate getPurchaseData() {
        return purchaseData;
    }

    public Vehicle setPurchaseData(final LocalDate purchaseData) {
        this.purchaseData = purchaseData;
        return this;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public Vehicle setRegistrationId(final String registrationId) {
        this.registrationId = registrationId;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public Vehicle setMileage(final int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getOperatingCosts() {
        return operatingCosts;
    }

    public Vehicle setOperatingCosts(final int operatingCosts) {
        this.operatingCosts = operatingCosts;
        return this;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Vehicle setInsurance(final Insurance insurance) {
        this.insurance = insurance;
        return this;
    }

    public TechReview getTechReview() {
        return techReview;
    }

    public Vehicle setTechReview(final TechReview techReview) {
        this.techReview = techReview;
        return this;
    }
}
