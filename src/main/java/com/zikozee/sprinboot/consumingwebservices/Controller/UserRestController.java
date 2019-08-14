package com.zikozee.sprinboot.consumingwebservices.Controller;

import com.zikozee.sprinboot.consumingwebservices.Service.UserService;
import com.zikozee.sprinboot.consumingwebservices.globalHandling.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theuserService){
        userService = theuserService;
    }

    @GetMapping("/users")
    public String getUsersList(){

        return "List:==>>" + userService.userList().toString();
        //return "List:==>>" + userService.alternativeUserList().toString();
    }

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable int userId){
        if(userId >= userService.userList().size() || userId<= 0){
            throw new UserNotFoundException("Student id not found -  " + userId);
        }
        return "User==>" + userService.user(userId);
    }

    @GetMapping("/address")
    public String getUserAddress(){
        return "User==>" + userService.address();
    }

    @GetMapping("/address/{userId}")
    public String getUserAddress(@PathVariable int userId){
        if(userId >= userService.userList().size() || userId<= 0){
            throw new UserNotFoundException("Student id not found -  " + userId);
        }
        return "User==>" + userService.userAddress(userId);
    }

    //You Can Extend As you wish
}
