package com.valter.spring_reactive_crud.service;

import com.valter.spring_reactive_crud.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService 
{

	Mono<User> save(User user);

	Flux<User> fetchAllUsers();

	Mono<User> findById(Long id);

	Mono<User> updateUser(Long id, User user);

	Mono<Void> deleteById(Long id);

	Mono<Void> deleteAll();

}
