package pl.gp.moto_service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String sureName;
    private String userName;
    private String email;

    private String password;
    private String passwordConfirm;

    private boolean enabled;
    private boolean tokenExpired;

    @ManyToMany
    private Set<Role> roles;

}
