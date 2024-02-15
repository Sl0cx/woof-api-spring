package com.m2i.woof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.m2i.woof.model.Dog;

public interface DogRepository extends JpaRepository<Dog, Long>{

}
