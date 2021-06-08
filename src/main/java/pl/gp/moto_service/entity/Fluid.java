package pl.gp.moto_service.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "fluids")
public class Fluid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "The fluid name field cannot be empty")
    private String fluidName;
    @NotBlank(message = "The fluid type field cannot be empty")
    private double quantity;
    @NotBlank(message = "The fluid cost field cannot be empty")
    private double fluidCost;


}
