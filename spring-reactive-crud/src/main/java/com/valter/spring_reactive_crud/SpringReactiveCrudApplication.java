package com.valter.spring_reactive_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
@EnableWebFlux
public class SpringReactiveCrudApplication
{

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory)
	{
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		
		return initializer;
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(SpringReactiveCrudApplication.class, args);
	}

}
