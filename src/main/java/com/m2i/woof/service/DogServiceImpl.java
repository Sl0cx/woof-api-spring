package com.m2i.woof.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.m2i.woof.dto.DogDto;
import com.m2i.woof.mapper.DogMapper;
import com.m2i.woof.model.Dog;
import com.m2i.woof.model.User;
import com.m2i.woof.repository.DogRepository;
import com.m2i.woof.repository.UserRepository;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DogDto> getListDog() {
        return dogRepository.findAll()
                .stream()
                .map(DogMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<DogDto> getListDogByUser(String username){
        User user = userRepository.findByIdentifiant(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return dogRepository.findByUser(user)
                .stream()
                .map(DogMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<DogDto> getListDogByProperties(String height, String race, Integer age, String geoloc) {
        return dogRepository.findByProperties(height, race, age, geoloc)
                .stream()
                .map(DogMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DogDto create(DogDto dogdto, String username) {
        User user = userRepository.findByIdentifiant(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        Dog dog = DogMapper.mapToEntity(dogdto, user);
        return DogMapper.mapToDto(dogRepository.save(dog));
    }
}
