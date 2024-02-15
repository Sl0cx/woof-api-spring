package com.m2i.woof.dto;

import com.m2i.woof.model.VaccinateStatus;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DogDto {
    private String height;
    private String race;
    private Integer age;
    private String geoloc;
    private VaccinateStatus vaccin;
}