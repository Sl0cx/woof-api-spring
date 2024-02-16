package com.m2i.woof.service;

import java.util.List;
import com.m2i.woof.dto.DogDto;

public interface DogService {
    public List<DogDto> getListDog();
    public List<DogDto> getListDogByUser(final String user);
    public List<DogDto> getListDogByProperties(final String height, final String race, final Integer age, final String geoloc);
    DogDto create(DogDto dog, String authentication);
}
