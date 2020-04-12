package com.example.spring_boot_swagger.service;

import com.example.spring_boot_swagger.model.Dog;

import java.util.List;

public interface DogCRUDInterface {
    public List<Dog> getDogs();

    public Dog getDogById(long id);

    public Dog createDog(Dog dog);

    public Dog alterDog(Dog dog);

    public Dog deleteDog(long id);
}
