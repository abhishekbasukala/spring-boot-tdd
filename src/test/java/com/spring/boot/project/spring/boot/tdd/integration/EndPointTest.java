package com.spring.boot.project.spring.boot.tdd.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.project.spring.boot.tdd.car.Car;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class EndPointTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getCars() throws Exception {
		ResponseEntity<Car[]> response = restTemplate.getForEntity("/rest/cars", Car[].class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()[0].getName()).isEqualTo("Honda");
		assertThat(response.getBody()[0].getType()).isEqualTo("SUV");
	}
	

}
