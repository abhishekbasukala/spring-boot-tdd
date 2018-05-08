package com.spring.boot.project.spring.boot.tdd.truck;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.boot.project.spring.boot.tdd.truck.exception.TruckNotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest(TruckController.class)
public class TruckControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TruckService truckService;
	
	@Test
	public void getTrucks() throws Exception {
		
		List<Truck> serviceResponse = retrieveTrucks();
		
		when(truckService.getAll()).thenReturn(serviceResponse);
		
		mockMvc.perform(get("/rest/trucks"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.length()").value(1));
	}

	@Test
	public void getTruck_ThrowsException() throws Exception {
		when(truckService.getAll()).thenThrow(new TruckNotFoundException());
		
		mockMvc.perform(get("/rest/trucks"))
		.andExpect(status().isNotFound());
	}
	
	private List<Truck> retrieveTrucks() {
		Truck truck = new Truck();
		truck.setName("Ford");
		List<Truck> serviceResponse = Arrays.asList(truck);
		return serviceResponse;
	}
	

}
