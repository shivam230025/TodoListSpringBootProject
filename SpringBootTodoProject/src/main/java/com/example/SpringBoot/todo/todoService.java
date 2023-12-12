package com.example.SpringBoot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class todoService {

	private static List<todo> todos= new ArrayList<>();
	
	private static int todosCount=0;
	
	static {
		todos.add(new todo(++todosCount, "shivam", "learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new todo(++todosCount, "shivam", "learn devOps", LocalDate.now().plusYears(2), false));
		todos.add(new todo(++todosCount, "shivam", "learn FullStack", LocalDate.now().plusYears(3), false));
	}
	
	public List<todo> getUserNameTodo(String loggedName){
		List<todo> list=  todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(loggedName)).toList();
		return list;
	}
	
	public void addtodo(String username, String description, LocalDate targetDate, boolean isDone) {
		todos.add(new todo(++todosCount, username, description, targetDate, isDone));
	}

	public void deleteByid(int id) {
		todos.removeIf(todo -> todo.getId()== id);
	}

	public todo getTodo(int id) {
		todo todo= todos.stream().filter(todo1 -> todo1.getId()== id).findFirst().get();
		return todo;
	}

	public void update(todo todo) {
		deleteByid(todo.getId());
		todos.add(todo);
	}
	
}
