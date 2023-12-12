package com.example.SpringBoot.updateTodo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.SpringBoot.todo.todo;
import com.example.SpringBoot.todo.todoRepository;
import com.example.SpringBoot.todo.todoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class updateTodoControllerJPA {

	private todoService todoService;
	
	private todoRepository todoRepository;

	public updateTodoControllerJPA(com.example.SpringBoot.todo.todoService todoService, todoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository= todoRepository;
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdatepage(@RequestParam int id, ModelMap modelMap) {
		//update
		
//		todo todo= todoService.getTodo(id);
		todo todo= todoRepository.findById(id).get();
		
		modelMap.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String doUpdate(ModelMap modelMap, @Valid todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		
//		todoService.update(todo);
		todoRepository.save(todo);
		
		return "redirect:todo";
	}
}
