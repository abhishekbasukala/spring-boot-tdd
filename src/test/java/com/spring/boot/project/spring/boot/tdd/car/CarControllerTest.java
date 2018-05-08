package com.spring.boot.project.spring.boot.tdd.car;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.boot.project.spring.boot.tdd.car.Car;
import com.spring.boot.project.spring.boot.tdd.car.CarController;
import com.spring.boot.project.spring.boot.tdd.car.CarService;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService carService;
	
	@Test
	public void getCar_ReturnsListOfCars() throws Exception {
		
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car("Honda","SUV");
		cars.add(car);
		
		when(carService.getAllCars()).thenReturn(cars);
		
		mockMvc.perform(get("/rest/cars"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.length()").value(1));

	}

}
