package com.example.Login_Register_Page.Service;

import com.example.Login_Register_Page.Entity.User;

public interface UserService {
    public User saveUser(User user);

    public void removeSessionMessage();
}
