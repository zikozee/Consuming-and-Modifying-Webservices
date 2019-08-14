package com.zikozee.sprinboot.consumingwebservices.Service;

import com.zikozee.sprinboot.consumingwebservices.Entity.Address;
import com.zikozee.sprinboot.consumingwebservices.Entity.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    User user(int userId);
    List<Address> address();
    Address userAddress(int userId);
}
