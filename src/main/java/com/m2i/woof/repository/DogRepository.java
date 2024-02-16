package com.m2i.woof.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.m2i.woof.model.Dog;
import com.m2i.woof.model.User;

public interface DogRepository extends JpaRepository<Dog, Long>{
    List<Dog> findByUser(User user);

    @Query(value = "SELECT d"
    +" FROM Dog as d" 
    +" WHERE (:height is NULL OR d.height LIKE :height)"
    +" OR (:race is NULL OR d.race LIKE :race)" 
    +" OR (:age is NULL OR d.age = :age)"
    +" OR (:geoloc is NULL OR d.geoloc LIKE :geoloc)")
    List<Dog> findByProperties(@Param("height") String height, @Param("race") String race, @Param("age") Integer age, @Param("geoloc") String geoloc);
}
