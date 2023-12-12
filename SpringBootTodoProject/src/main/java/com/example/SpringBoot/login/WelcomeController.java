package com.example.SpringBoot.login;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

	@GetMapping("/")
	public String getWelcomepage(ModelMap map) {
		map.addAttribute("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		String nameString= SecurityContextHolder.getContext().getAuthentication().getName();
		return nameString;
	}
}
