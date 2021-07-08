package pl.gp.moto_service.entity;


import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    private Set<User> users;

    }

