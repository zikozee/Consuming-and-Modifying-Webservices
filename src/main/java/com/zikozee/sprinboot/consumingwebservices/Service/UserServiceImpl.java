package com.zikozee.sprinboot.consumingwebservices.Service;

import com.zikozee.sprinboot.consumingwebservices.ConsumingwebservicesApplication;
import com.zikozee.sprinboot.consumingwebservices.Entity.Address;
import com.zikozee.sprinboot.consumingwebservices.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(ConsumingwebservicesApplication.class);
    private RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(RestTemplate myRestTemplate){
        restTemplate = myRestTemplate;
    }

    @Override
    public List<User> userList(){
        ResponseEntity<List<User>> response = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/users/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>(){});
        List<User> users = response.getBody();
        return users;
    }

    @Override
    public User user(int id) {
        String userId = Integer.toString(id);
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        User user = restTemplate.
                getForObject(url, User.class);
        return user;
    }

    @Override
    public List<Address> address() {
        List<Address> addresses = new ArrayList<>();
        
        for(User user : userList()){
            addresses.add(user.getAddress());
        }
        
        return addresses;
    }

    @Override
    public Address userAddress(int userId) {
        Address myAddress = null;
        for(User user : userList()){
            if(user.getId() == userId){
                myAddress=  userList().get(userId).getAddress();
            }
        }
        return myAddress;
    }
}
