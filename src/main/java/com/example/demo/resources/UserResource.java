package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/users")
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
	
	//add um novo usuário e retorna um código 201
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = userServices.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//deletar usuário
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userServices.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//atualizar usuário
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = userServices.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
