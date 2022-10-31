package com.example.demo.controller;

import org.json.simple.JSONValue;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserJson;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller

public class controller {
	@Autowired
	UserDao userDao;
	@Autowired
	UserJson userJson;
	@Autowired
	UserService userService;

	// @GetMapping("/")
	// public String showForm(@ModelAttribute("user") User user,Model model) {
	// User userinfo = new User();
	// model.addAttribute("userinfo",userinfo);
	// return "form";
	// }

	@GetMapping("/")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "form";
	}

	@PostMapping("/add")
	//傳入json
	public String create(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		Map<String,Object>map=new HashMap<>();
		map.put("name",user.getName());
		map.put("sex",user.getSex());
		map.put("phone",user.getPhone());
		map.put("area",user.getArea());

		String json=JSONValue.toJSONString(map);
		System.out.println(json);

		userJson.CreateUser_Json(json);

		return "submit";
	}

	//單一傳入key value
	//   @PostMapping("/submit")
	//   public String create(@ModelAttribute User user,Model model)
	//   {
	//   model.addAttribute("user", user);
	//   userDao.CreateUser(user);
	//   return "submit";
	//   }
	//   /


}
