package com.spring.boot.project.spring.boot.tdd.truck;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.UrlAssert;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@RunWith(MockitoJUnitRunner.class)
public class TruckServiceTest {

	@InjectMocks
	private TruckService truckService;

	@Mock
	private RestTemplate restTemplate;

	@Test
	public void testName() throws Exception {
		
		String jsonString = new JSONObject()
                .put("mirror", "Hello World!")
                .put("tyre", new JSONObject()
                     .put("radius", 5)).toString();
		
		when(restTemplate.getForObject(Matchers.anyString(),Matchers.any())).thenReturn(jsonString);

		List<Truck> trucks = truckService.getAll();

		verify(restTemplate).getForObject("/test", String.class);
		Assertions.assertThat(trucks.get(0).getName()).isEqualTo("Ford");
	}

}
