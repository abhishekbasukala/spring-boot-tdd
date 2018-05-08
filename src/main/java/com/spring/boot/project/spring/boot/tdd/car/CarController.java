package com.spring.boot.project.spring.boot.tdd.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/rest/cars")
	public List<Car> getCars(){
		return carService.getAllCars();
	}

}
