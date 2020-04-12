package com.example.spring_boot_swagger.controller;

import com.example.spring_boot_swagger.model.Dog;
import com.example.spring_boot_swagger.service.DogCRUDInterface;
import com.example.spring_boot_swagger.serviceImpl.DogCRUD;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(description = "宠物狗管理")
@RestController
@RequestMapping(value = "/dog", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class DogController {
    private DogCRUDInterface dogCRUD = new DogCRUD();

    /*@ApiOperation(value = "查询所有狗狗", notes = "不添加参数查询所有狗狗信息")
    @GetMapping
    public List<Dog> getDogs() {
        return dogCRUD.getDogs();
    }*/

    @ApiOperation(value = "查询狗狗", notes = "根据用户输入的name值模糊查询相关的所有狗狗，若不带该参数或为\"\"，则返回所有狗狗信息")
    @GetMapping
    public List<Dog> getDogs(String name) {
        System.out.println("name:" + name);
        if (name != null) {
            name = name.trim();
            if (!"".equals(name) ) {
                List<Dog> dogs = dogCRUD.getDogs();
                List<Dog> resultDogs = new ArrayList<>();
                for (Dog dog : dogs) {
                    if (dog.getName().contains(name)) {
                        resultDogs.add(dog);
                    }
                }
                return resultDogs;
            }
        }
        return dogCRUD.getDogs();
    }

    @ApiOperation(value = "根据id查询狗狗", notes = "根据狗狗的编号查询信息")
    @GetMapping(value = "/{id}")
    public Dog getDogById(@PathVariable long id) {
        return dogCRUD.getDogById(id);
    }

    @ApiOperation(value = "增加狗狗", notes = "根据狗狗的实际信息，进行收养，并给予编号")
    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Dog createDog(@RequestBody Dog dog) {//id属性由后台逻辑生成，此处提交无需id属性
        return dogCRUD.createDog(dog);
    }

    @ApiOperation(value = "增加狗狗2", notes = "根据狗狗的实际信息，进行收养，并给予编号")
    @PostMapping(value = "/post", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<List<Integer>> createDog2(
            @RequestParam Integer id,
            @RequestParam Long bid,
            @ApiParam(value = "计划起飞时间查询起始时间", required = true) @RequestParam String name,
            @RequestParam Date date,
            @RequestParam Boolean flag,
            @RequestParam List<Integer> ids,
//            @RequestParam Map<String, String> maps,
            @RequestBody String bname,
            @RequestBody Integer bodyid,
            @RequestBody Dog dog,
            @ApiParam(value = "计划起飞时间查询起始时间", required = true) @RequestBody List<Dog> dogs
            ) {

        return null;
    }

    @ApiOperation(value = "修改狗狗", notes = "根据狗狗编号修改信息")
    @PutMapping(value = "/{id}")
    public Dog alterDog(@PathVariable long id, @RequestBody Dog dog) {//id属性在url路径中，此处提交无需id属性
        dog.setId(id);
        return dogCRUD.alterDog(dog);
    }

    @ApiOperation(value = "删除狗狗", notes = "根据狗狗编号进行放生")
    @DeleteMapping(value = "/{id}")
    public Dog deleteDog(@PathVariable long id) {
        return dogCRUD.deleteDog(id);
    }

    /*非REST API格式*/
    @ApiOperation(value = "模糊查询1", notes = "传递参数进行查询")
    @RequestMapping(value = "/name1", method = RequestMethod.GET)
    public Dog getDogByName1(String name, Integer age) {//访问时 name参数可为空，无限制。
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        Dog dog = new Dog();
        dog.setName(name);
        dog.setAge(age);
        System.out.println(dog);
        return dog;
    }
    @ApiOperation(value = "模糊查询3", notes = "传递参数进行查询")
    @RequestMapping(value = "/name3", method = RequestMethod.GET)
    public Dog getDogByName3(@RequestParam String name) {//Required String parameter 'name' is not present(不存在) 访问时 name参数不可为空， 无限制。[加上@RequestParam注解和不加，相当于加了个非空限制]
        Dog dog = new Dog();
        dog.setName(name);
        return dog;
    }

    /*@ApiOperation(value = "模糊查询1", notes = "传递参数进行查询")
    @RequestMapping(value = "/name1", method = RequestMethod.POST)
    public Dog getDogByName1(String name) {//访问时 name参数可为空，无限制。
        System.out.println("name:" + name);
        Dog dog = new Dog();
        dog.setName(name);
        System.out.println(dog);
        return dog;
    }
    @ApiOperation(value = "模糊查询3", notes = "传递参数进行查询")
    @RequestMapping(value = "/name3", method = RequestMethod.POST)
    public Dog getDogByName3(@RequestParam String name) {//Required String parameter 'name' is not present(不存在) 访问时 name参数不可为空， 无限制。[加上@RequestParam注解和不加，相当于加了个非空限制]
        Dog dog = new Dog();
        dog.setName(name);
        return dog;
    }*/

}
