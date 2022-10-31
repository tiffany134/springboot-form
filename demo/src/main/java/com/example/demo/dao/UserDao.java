package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Component
@Repository
public class UserDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;
  public void CreateUser(User user) {
    String sql = "INSERT INTO test(name,sex,phone,area)"+"VALUES(?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getName(),user.getSex(),user.getPhone(),user.getArea() });
  }

}
  