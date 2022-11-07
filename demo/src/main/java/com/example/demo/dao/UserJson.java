package com.example.demo.dao;

import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import net.sf.json.JSONObject;
import org.postgresql.util.PGobject;


@Component
@Repository
public class UserJson {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



  
  public void CreateUser_Json(PGobject data) {
   
    jdbcTemplate.update("INSERT INTO user_info(data) VALUES (to_json(?))",data);
  }
  
  public PGobject getByid(int id){
  PGobject t = jdbcTemplate.queryForObject("select data from user_info where id=?",PGobject.class, id);
  return t;
  }

  


  //根據用戶uid修改數據
  public void Updateinfo(PGobject data,int id){
    // String sql ="UPDATE user_info SET " 
    // "name=:name,sex=:sex,phone=:phone,area=:area" +
    // " WHERE id=:id";
    jdbcTemplate.update("UPDATE user_info SET data=to_json(?) where id=?",data,id);
    
  }
    
}




