package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;

@RestController
@RequestMapping("/Products")
public class ProductResource {

	@Autowired
	private ProductServices productServices ;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findByid(@PathVariable Long id){
		Product obj = productServices.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
