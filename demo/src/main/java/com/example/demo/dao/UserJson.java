package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class UserJson {
  @Autowired
  private JdbcTemplate jdbcTemplate;
  public void CreateUser_Json(String data) {
   
    jdbcTemplate.update("INSERT INTO user_info(data) VALUES (to_json(?))",data);
  }

}
  