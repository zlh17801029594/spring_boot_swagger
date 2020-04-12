package com.example.spring_boot_swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "狗狗")
public class Dog {
    @ApiModelProperty(value = "编号", hidden = true)
    private long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;

    private User test0;

    public User getTest0() {
        return test0;
    }

    public void setTest0(User test0) {
        this.test0 = test0;
    }

    private List<User> test1;
    private List<Integer> test2;

    public List<User> getTest1() {
        return test1;
    }

    public void setTest1(List<User> test1) {
        this.test1 = test1;
    }

    public List<Integer> getTest2() {
        return test2;
    }

    public void setTest2(List<Integer> test2) {
        this.test2 = test2;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*private Dog(DogBuilder dogBuilder) {
        this.id = dogBuilder.id;
        this.name = dogBuilder.name;
        this.age = dogBuilder.age;
    }



    public static class DogBuilder{
        private long id;
        private String name;
        private int age;

        public DogBuilder id(long id) {
            this.id = id;
            return this;
        }

        public DogBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Dog build() {
            return new Dog(this);
        }
    }*/
}
