package com.valter.spring_reactive_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.valter.spring_reactive_crud.model.User;
import com.valter.spring_reactive_crud.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController 
{
	@Autowired
	private UserService service;
	
	// Save resource
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<User> saveUser(@RequestBody User user)
	{
		return service.save(user);
	}
	
	// Fetch all resources
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public Flux<User> getAllUsers()
	{
		return service.fetchAllUsers();
	}
	
	// Fetch resources by ID
	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<User> getUserById(@PathVariable Long id)
	{
		return service.findById(id);
	}
	
	// Update resource
	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<User> updateUser(@PathVariable Long id, @RequestBody User user)
	{
		return service.updateUser(id, user);
	}
	
	// Delete resources
	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteUserById(@PathVariable Long id)
	{
		return service.deleteById(id);
	}
	
	// Delete all resources
	@DeleteMapping("/users")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteUser()
	{
		return service.deleteAll();
	}
}
