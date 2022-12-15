package com.github.weronika.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ZooApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(ZooApplication.class, args);

	}

}
