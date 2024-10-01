package com.valter.spring_reactive_crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valter.spring_reactive_crud.dao.UserRepository;
import com.valter.spring_reactive_crud.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceimpl implements UserService
{
	@Autowired
	private UserRepository repository;
	
	@Override
	public Mono<User> save(User user)
	{
		return repository.save(user);
	}

	@Override
	public Flux<User> fetchAllUsers()
	{
		return repository.findAll();
	}

	@Override
	public Mono<User> findById(Long id)
	{
		return repository.findById(id);
	}

	@Override
	public Mono<User> updateUser(Long id, User user)
	{
		return repository.findById(id).map(Optional::of)
				.defaultIfEmpty(Optional.empty())
				.flatMap(optionalUser ->
				{
					if (optionalUser.isPresent())
					{
						user.setId(id);
						return repository.save(user);
					}
			return Mono.empty();
				});
	}

	@Override
	public Mono<Void> deleteById(Long id)
	{
		return repository.deleteById(id);
	}

	@Override
	public Mono<Void> deleteAll()
	{
		return repository.deleteAll();
	}
}
