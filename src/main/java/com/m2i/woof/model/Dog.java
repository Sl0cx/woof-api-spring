package com.m2i.woof.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "dog")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDog;
    private String height;
    private String race;
    private Integer age;
    private String geoloc;
    @Enumerated(EnumType.STRING)
    private VaccinateStatus vaccin;
    @ManyToOne(targetEntity = User.class)
    private User user;
}
