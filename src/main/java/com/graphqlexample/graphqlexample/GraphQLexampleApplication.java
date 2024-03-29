package com.graphqlexample.graphqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @Log
@EnableCaching
@ComponentScan
public class GraphQLexampleApplication {
	public static void main(String[] args) {

		SpringApplication.run(GraphQLexampleApplication.class, args);

	}
}
