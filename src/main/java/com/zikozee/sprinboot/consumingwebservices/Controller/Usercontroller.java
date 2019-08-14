package com.zikozee.sprinboot.consumingwebservices.Controller;

import com.zikozee.sprinboot.consumingwebservices.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

    private UserService userService;

    @Autowired
    public Usercontroller(UserService theuserService){
        userService = theuserService;
    }

    @GetMapping("/users")
    public String getUsersList(){

        return "List:==>>" + userService.userList().toString();
    }

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable int userId){

        return "User==>" + userService.user(userId);
    }

    @GetMapping("/address")
    public String getUserAddress(){
        return "User==>" + userService.address();
    }

    @GetMapping("/address/{userId}")
    public String getUserAddress(@PathVariable int userId){

        return "User==>" + userService.userAddress(userId);
    }
}
