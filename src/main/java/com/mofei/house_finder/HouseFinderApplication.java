package com.mofei.house_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HouseFinderApplication {


	public static void main(String[] args) {
		SpringApplication.run(HouseFinderApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}
}
