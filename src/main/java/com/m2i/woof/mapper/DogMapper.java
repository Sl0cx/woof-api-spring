package com.m2i.woof.mapper;

import com.m2i.woof.dto.DogDto;
import com.m2i.woof.model.Dog;

public class DogMapper {
    public static DogDto mapToDto(Dog dog){

        return DogDto.builder()
                .height(dog.getHeight())
                .race(dog.getRace())
                .age(dog.getAge())
                .geoloc(dog.getGeoloc())
                .vaccin(dog.getVaccin())
                .build();
    }

    public static Dog mapToEntity(DogDto dogDto){
        return Dog.builder()
                .height(dogDto.getHeight())
                .race(dogDto.getRace())
                .age(dogDto.getAge())
                .geoloc(dogDto.getGeoloc())
                .vaccin(dogDto.getVaccin())
                .build();
    }
}
