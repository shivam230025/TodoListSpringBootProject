package com.example.SpringBoot.updateTodo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.SpringBoot.todo.todo;
import com.example.SpringBoot.todo.todoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class updateTodoController {

	private todoService todoService;

	public updateTodoController(com.example.SpringBoot.todo.todoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdatepage(@RequestParam int id, ModelMap modelMap) {
		//update
		todo todo= todoService.getTodo(id);
		modelMap.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String doUpdate(ModelMap modelMap, @Valid todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		todoService.update(todo);
		return "redirect:todo";
	}
}
