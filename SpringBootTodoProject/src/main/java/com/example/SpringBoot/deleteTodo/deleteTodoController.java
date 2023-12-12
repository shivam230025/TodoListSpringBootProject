package com.example.SpringBoot.deleteTodo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBoot.todo.todoService;

//@Controller
public class deleteTodoController {
	
	private todoService todoService;

	public deleteTodoController(com.example.SpringBoot.todo.todoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//delete todo
		todoService.deleteByid(id);
		return "redirect:todo";
	}
}
