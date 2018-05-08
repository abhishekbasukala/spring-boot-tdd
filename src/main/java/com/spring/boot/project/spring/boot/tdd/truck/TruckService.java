package com.spring.boot.project.spring.boot.tdd.truck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TruckService {
	
	@Autowired
	private RestTemplate restTemplate;

	public List<Truck> getAll() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = restTemplate.getForObject("/test", String.class);
		Components component= mapper.readValue(jsonString, Components.class);
		List<Truck> trucks = new ArrayList<Truck>();
		if(component.getTyre().getRadius()> 4){
			Truck truck = new Truck();
			truck.setName("Ford");
			trucks.add(truck);
		}
		return trucks;
	}

}
