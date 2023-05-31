package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.services.CategoryServices;

@RestController
@RequestMapping("/Categories")
public class CategoryResource {

	@Autowired
	private CategoryServices categoryServices ;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findByid(@PathVariable Long id){
		Category obj = categoryServices.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
