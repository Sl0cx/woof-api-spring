package com.m2i.woof.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m2i.woof.dto.DogDto;
import com.m2i.woof.mapper.DogMapper;
import com.m2i.woof.repository.DogRepository;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<DogDto> getListDog() {
        return dogRepository.findAll()
                .stream()
                .map(DogMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
