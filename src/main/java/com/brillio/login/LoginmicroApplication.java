package com.brillio.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LoginmicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginmicroApplication.class, args);
	}

}
