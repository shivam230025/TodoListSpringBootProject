package com.example.SpringBoot.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Controller
@SessionAttributes("name")
public class todoController {

	private todoService todoService;
	
	public todoController(com.example.SpringBoot.todo.todoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todo")
	public String gotoTodo(ModelMap model) {
		String username= (String) model.get("name");
		List<todo> todos= todoService.getUserNameTodo(username);
		model.addAttribute("todos", todos);
		return "todo-list";
	}
}
