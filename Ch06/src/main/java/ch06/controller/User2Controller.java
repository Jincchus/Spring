package ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch06.dto.User2DTO;
import ch06.service.User2Service;

@Controller
public class User2Controller {
	
	@Autowired
	private User2Service service;
	
	@GetMapping("/user2/list")
	public String list(Model model) {
		List<User2DTO> users = service.selectUser2s();
		model.addAttribute("users",users);
		
		return "/user2/list";
	}
	
	@GetMapping("/user2/register")
	public String register() {
		return "/user2/register";
	}
	
	@GetMapping("/user2/modify")
	public String modify() {
		return "/user2/modify";
	}
	
}
