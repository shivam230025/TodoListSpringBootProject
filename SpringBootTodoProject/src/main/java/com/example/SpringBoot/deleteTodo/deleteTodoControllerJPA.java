package com.example.SpringBoot.deleteTodo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBoot.todo.todo;
import com.example.SpringBoot.todo.todoRepository;
import com.example.SpringBoot.todo.todoService;

import jakarta.persistence.Id;

@Controller
public class deleteTodoControllerJPA {
	
	private todoService todoService;
	
	private todoRepository todoRepository;

	public deleteTodoControllerJPA(com.example.SpringBoot.todo.todoService todoService, todoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository= todoRepository;
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//delete todo
		
//		todoService.deleteByid(id);
		todoRepository.delete(todoRepository.findById(id).get());
		
		return "redirect:todo";
	}
}
