package com.netflix.demo;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		try {
			DataLoader.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
