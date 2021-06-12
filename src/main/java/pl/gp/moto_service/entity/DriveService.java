package pl.gp.moto_service.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class DriveService {
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
    @DecimalMin("0")
    private long serviceCost;
}
