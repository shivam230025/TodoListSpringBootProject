package com.example.SpringBoot.addTodo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.SpringBoot.todo.todo;
import com.example.SpringBoot.todo.todoRepository;
import com.example.SpringBoot.todo.todoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class addTodoControllerJPA {
	
	private todoService todoService;
	
	private todoRepository todoRepository;

	public addTodoControllerJPA(com.example.SpringBoot.todo.todoService todoService, todoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository= todoRepository;
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodo(ModelMap modelMap) {
		String username= (String)modelMap.get("name");
		todo todo= new todo(0, username, "", LocalDate.now(), false);
		modelMap.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String gotoTodoList( ModelMap modelMap,@Valid todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username= (String)modelMap.get("name");
		
//		todoService.addtodo(username, todo.getDescription(), todo.getTargetDate() , false);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		return "redirect:todo";
	}
	
}
