package com.example.spring_boot_swagger.serviceImpl;

import com.example.spring_boot_swagger.model.Dog;
import com.example.spring_boot_swagger.service.DogCRUDInterface;

import java.util.ArrayList;
import java.util.List;

public class DogCRUD implements DogCRUDInterface {
    private List<Dog> dogs = new ArrayList<>();
    @Override
    public List<Dog> getDogs() {
        return dogs;
    }

    @Override
    public Dog getDogById(long id) {
        for (Dog dog : dogs) {
            if (dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    @Override
    public Dog createDog(Dog dog) {
        long max = 0;
        for (Dog temp : dogs) {
            if (temp.getId() > max) {
                max = temp.getId();
            }
        }
        dog.setId(++max);
        dogs.add(dog);
        return dog;
    }

    @Override
    public Dog alterDog(Dog dog) {
        Dog temp = getDogById(dog.getId());
        if (temp != null) {
            temp.setName(dog.getName());
            temp.setAge(dog.getAge());
            return dog;
        }
        return null;
    }

    @Override
    public Dog deleteDog(long id) {
        for (Dog dog : dogs) {
            if (dog.getId() == id) {
                dogs.remove(dog);
                return dog;
            }
        }
        return null;
    }
}
