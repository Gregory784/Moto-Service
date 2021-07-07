package pl.gp.moto_service.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {
    private String firstName;
    private String sureName;
    private String userName;
    private String email;

    private String password;
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

}
