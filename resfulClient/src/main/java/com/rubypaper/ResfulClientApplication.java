package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.rubypaper"})
@SpringBootApplication
public class ResfulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResfulClientApplication.class, args);
	}

}
