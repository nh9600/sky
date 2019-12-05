package com.sky.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sky.test.dao.UserDAO;
import com.sky.test.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Resource
	private UserDAO udao;
	
	@GetMapping("/users")
	public String getUserList(Model m,@ModelAttribute UserVO user){
		m.addAttribute("users",udao.getUserList(user));
		return "user/list";
	}

}
