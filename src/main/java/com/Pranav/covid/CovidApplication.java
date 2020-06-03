package com.Pranav.covid;

import com.Pranav.covid.Service.Crawling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication {

	public static void main(String[] args) {
		Crawling crawling=new Crawling();
		crawling.extractData();
		SpringApplication.run(CovidApplication.class, args);
	}

}
