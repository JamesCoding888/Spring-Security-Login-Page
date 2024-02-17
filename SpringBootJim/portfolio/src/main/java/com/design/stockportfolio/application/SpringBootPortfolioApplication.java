package com.design.stockportfolio.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPortfolioApplication.class, args);
	}

}
