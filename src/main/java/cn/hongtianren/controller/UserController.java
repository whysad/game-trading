package cn.hongtianren.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hongtianren.entity.User;
import cn.hongtianren.service.UserService;

@Controller
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
		@PostMapping("/create")
		@ResponseBody
		public String create(User user,int role){
			try {
				userService.create(user, role);
			} catch (SQLException e) {
				e.printStackTrace();
				return "用户已存在";
			}
			return "ok";
		} 
}
