package com.example.spring_boot_swagger.controller;

import com.example.spring_boot_swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Api(description = "用户管理")
public class UserController {

    @ApiOperation(value = "纯字符串", notes = "返回String")
    @RequestMapping(value = "/string", method = RequestMethod.GET)
    public String string() {
        return "hello";
    }

    @ApiOperation(value = "字符串数组", notes = "返回String数组")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String[] hello() {
        return new String[]{"hello"};
    }

    @ApiOperation(value = "字符串列表", notes = "返回List_String")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        users.add("xiaozhou");
        users.add("xiaoming");
        return users;
    }

    @ApiOperation(value = "GET对象", notes = "不带参数GET方式返回对象")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();
        user.setUsername("小红帽");
        user.setAge(11);
        return user;
    }

    @ApiOperation(value = "GET对象", notes = "带参数GET方式返回对象")
    @RequestMapping(value = "/getUserByName/{username}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    /*POST请求的@RequestBody很重要*/
    @ApiOperation(value = "POST对象", notes = "不带参数POST方式返回对象")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public User add(@RequestBody User user) {
        System.out.println(user);
        user.setAge(24);
        return user;
    }
}
