package com.zuzana.expensetrackerbe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zuzana.expensetrackerbe.repositories.CategoryRepo;
import com.zuzana.expensetrackerbe.models.Category;

@CrossOrigin
@RestController
public class CategoryController {
		
	@Autowired
	private CategoryRepo repo;
	
	@GetMapping("/categories")
	List<Category> getCategories() {
		return repo.findAll();
	}
	
	@PostMapping("/categories")
	Category addCategory(@RequestBody Category cat) {
		return repo.save(cat);
	}
	
	@PutMapping("/categories/{id}")
	Category updateCategory(@RequestBody Category cat) {
		return repo.save(cat);
	}
	
	@DeleteMapping("/categories/{id}")
	void deleteCategory(@PathVariable int id) {
		repo.deleteById(id);
	}
	

}
