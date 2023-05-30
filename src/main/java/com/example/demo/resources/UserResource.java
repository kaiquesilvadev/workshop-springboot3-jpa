package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserServices userServices ;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findByid(@PathVariable Long id){
		User obj = userServices.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
