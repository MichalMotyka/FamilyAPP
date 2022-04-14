package com.example.FamilyMemberApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FamilyMemberAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(FamilyMemberAppApplication.class, args);
	}

}
