package com.valter.spring_reactive_crud.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.valter.spring_reactive_crud.model.User;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long>
{
	
}
