package pl.gp.moto_service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String sureName;
    private String userName;
    private String email;

    private String password;
    private String passwordConfirm;

    private boolean enabled;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @OneToMany
    private List<Vehicle> vehicles;

}
