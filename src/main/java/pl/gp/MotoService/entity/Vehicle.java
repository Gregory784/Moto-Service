package pl.gp.MotoService.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean archives = false;
    private String name;
    private String model;
    private String vin;
    private LocalDate productionData;
    private LocalDate purchaseData;
    private String registrationId;
    private int mileage;
    private int operatingCosts;

    public Vehicle(final int id, final boolean archives, final String name, final String model, final String vin, final LocalDate productionData, final LocalDate purchaseData, final String registrationId, final int mileage, final int operatingCosts) {
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
    }

    public Vehicle() {

    }

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", archives=" + archives +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", productionData=" + productionData +
                ", purchaseData=" + purchaseData +
                ", registrationId='" + registrationId + '\'' +
                ", mileage=" + mileage +
                ", operatingCosts=" + operatingCosts +
                '}';
    }
}
