package com.example.demo.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User;

public class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            //ResultSet resultSet = 從資料庫中查詢出來的數據
               User  user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                user.setPhone(resultSet.getString("phone"));
                user.setArea(resultSet.getString("area"));
    
            return user;
              //返回值= 要轉換的Java Object
        }
    }

