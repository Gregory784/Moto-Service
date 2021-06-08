package pl.gp.moto_service.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "oils")

public class Oil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "The oil name field cannot be empty")
    private String oilName;
    @NotBlank(message = "The oil type field cannot be empty")
    //regex
    private String viscositySAE;
    @Min(0)
    private double quantity;
    @Min(0)
    private double oilCost;

}
