package com.meow.themeowproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ThemeowprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThemeowprojectApplication.class, args);
	}

}
