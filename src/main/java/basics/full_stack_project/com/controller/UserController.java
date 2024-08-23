package basics.full_stack_project.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import basics.full_stack_project.com.entity.UserInfoEntity;
import basics.full_stack_project.com.services.UserService;

@Controller
public class UserController {
	
	UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/sample-html")
	public String firstHtmlSample() {
		
		return "index";
	}
	
	@GetMapping("/users")
	public String listAllUsers(Model model) {
		List<UserInfoEntity> listUsers = userService.listAllUsers();
		model.addAttribute("listUsers",listUsers);
		return "Users";
		
	}

}
