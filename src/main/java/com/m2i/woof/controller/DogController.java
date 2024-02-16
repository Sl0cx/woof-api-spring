package com.m2i.woof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.woof.dto.DogDto;
import com.m2i.woof.model.Dog;
import com.m2i.woof.model.User;
import com.m2i.woof.service.DogServiceImpl;

@RestController
@RequestMapping("dog")
public class DogController {
    @Autowired
    private DogServiceImpl dogService;

    @GetMapping("")
    public List<DogDto> getListDog(){
        return dogService.getListDog();
    }

    @GetMapping("/list")
    public List<DogDto> getListDogByUser(final Authentication authentication){
        return dogService.getListDogByUser(authentication.getName());
    }

    @GetMapping("/list/properties")
    public List<DogDto> getListDogByProperties(
        @RequestParam(name = "height", required=false) final String height,
        @RequestParam(name = "race", required=false) final String race,
        @RequestParam(name = "age", required=false) final Integer age,
        @RequestParam(name = "geoloc", required=false) final String geoloc){
        return dogService.getListDogByProperties(height, race, age, geoloc);
    }    

    @PostMapping("/create")
    public DogDto create(@RequestBody DogDto dog, final Authentication authentication){
        return dogService.create(dog, authentication.getName());
    }
}
