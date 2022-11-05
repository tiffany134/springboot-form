package com.example.demo.controller;

import org.json.simple.JSONValue;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserJson;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import net.sf.json.JSONObject;

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

	@GetMapping("/user")
	public String addinfo(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "form";
	}

	@PostMapping("/user/add")
	//傳入json
	public String create(@ModelAttribute User user, Model model) throws Exception {
		model.addAttribute("user", user);
		Map<String,Object>map=new HashMap<>();
		map.put("name",user.getName());
		map.put("sex",user.getSex());
		map.put("phone",user.getPhone());
		map.put("area",user.getArea());

		String json=JSONValue.toJSONString(map);
		
		userService.CreateUser_Json(json);

		return "add";
	}

	@GetMapping("/update")
	public String update() {
		//User user = new User();
		//model.addAttribute("user", user);
		return "update";
	}
	
    @GetMapping("/update/{id}")
	@ResponseBody
	public JSONObject update(@PathVariable ("id") int id){ 
		//public User getid(@PathVariable("id") int id) {
		User u	= userService.getById(id);
		System.out.println("@@@"+u.getName()+u.getSex()+u.getPhone()+u.getArea());
		//JSONObject json=JSONObject.parseObject(u);
		//System.out.println("@@@@@!!!!!!"+json);
        JSONObject jo2 =JSONObject.fromObject(u);
		System.out.println("@@@"+jo2);
        return jo2 ;
	}


	@PostMapping("/update/{id}")
	
	public @ResponseBody  String updateinfo(@RequestBody User user,@PathVariable ("id") int id) throws Exception
	{
		// String name=user.getName();
		// String sex=user.getSex();
		// String phone=user.getPhone();
		// String area=user.getArea();
		Map<String,Object>map=new HashMap<>();
		map.put("name",user.getName());
		map.put("sex",user.getSex());
		map.put("phone",user.getPhone());
		map.put("area",user.getArea());

		String json=JSONValue.toJSONString(map);
		
		userService.Update(json,id);
		System.out.println("!!!!!!!!!!!"+json);   
       return "Ok";
	}
   
}



	// @GetMapping("/update/{id}")
	// @ResponseBody
	// public String update(@PathVariable ("id") int id){ 
	// 	//public User getid(@PathVariable("id") int id) {
	// 	User u	= userService.getById(id);
	// 	System.out.println("@@@"+u.getName()+u.getSex()+u.getPhone()+u.getArea());
	// 	//JSONObject json=JSONObject.parseObject(u);
	// 	//System.out.println("@@@@@!!!!!!"+json);
    //     JSONObject jo2 =JSONObject.fromObject(u);
	// 	System.out.println("@@@"+jo2);
    //     return "update" ;
	// }



	//單一傳入key value
	//   @PostMapping("/submit")
	//   public String create(@ModelAttribute User user,Model model)
	//   {
	//   model.addAttribute("user", user);
	//   userDao.CreateUser(user);
	//   return "submit";
	//   }
	//   /



