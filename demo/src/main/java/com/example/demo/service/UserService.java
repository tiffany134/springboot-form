package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserJson;
import com.example.demo.model.User;

@Component
@Service
public class UserService {
    @Autowired
    private UserDao userdao;
    public void CreateUser(User user){
        userdao.CreateUser(user);
    }
    @Autowired
    private UserJson userjson;
    public void CreateUser_Json(String data){
        userjson.CreateUser_Json(data);
    }

}
