package com.m2i.woof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.woof.dto.DogDto;
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
}
