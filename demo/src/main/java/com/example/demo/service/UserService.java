package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.el.PropertyNotFoundException;

import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserJson;
import com.example.demo.model.User;

import net.sf.json.JSONObject;
import org.postgresql.util.PGobject;

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
    public void CreateUser_Json(String data) throws Exception{
        PGobject p =new PGobject();
        p.setType("jsonb");
        p.setValue(data);
        userjson.CreateUser_Json(p);
    }
    
    public User getById(int id) {
        PGobject p =userjson.getByid(id);
        JSONObject json = JSONObject.fromObject(p);
        String s=json.getString("value").toString();
        JSONObject json1= JSONObject.fromObject(s);
        
        User u =new User();
        u.setName(json1.getString("name"));
        u.setArea(json1.getString("area"));
        u.setPhone(json1.getString("phone"));
        u.setSex(json1.getString("sex"));
		return u;
	}
  public void Update(String data,int id) throws Exception
  {
    PGobject r =new PGobject();
    r.setType("jsonb");
    r.setValue(data);
    userjson.Updateinfo(r,id);
} 
   
}