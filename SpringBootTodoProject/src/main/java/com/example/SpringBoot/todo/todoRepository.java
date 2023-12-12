package com.example.SpringBoot.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import jakarta.persistence.Id;

public interface todoRepository extends JpaRepository<todo, Id>{

	List<todo> findByUsername(String username);

	Optional<todo> findById(int id);

	
	

}
