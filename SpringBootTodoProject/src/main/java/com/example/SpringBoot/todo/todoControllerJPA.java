package com.example.SpringBoot.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class todoControllerJPA {

	private todoService todoService;
	
	private todoRepository todoRepository;
	
	public todoControllerJPA(com.example.SpringBoot.todo.todoService todoService, todoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository= todoRepository;
	}

	@RequestMapping("todo")
	public String gotoTodo(ModelMap model) {
		String username= (String) model.get("name");
		
//		List<todo> todos= todoService.getUserNameTodo(username);
		List<todo> todos= todoRepository.findByUsername(username);
		
		model.addAttribute("todos", todos);
		return "todo-list";
	}
}
