package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderServices;

@RestController
@RequestMapping("/Orders")
public class OrderResource {

	@Autowired
	private OrderServices orderServices ;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = orderServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findByid(@PathVariable Long id){
		Order obj = orderServices.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
