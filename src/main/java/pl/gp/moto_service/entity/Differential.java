package pl.gp.moto_service.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Differential extends DriveService {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String serviceType = "Differential oil";
    @ManyToOne
    private Oil oil;
}
