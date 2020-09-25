package br.com.gustavoakira.master.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavoakira.master.entities.Cars;
import br.com.gustavoakira.master.service.CarsService;

@WebMvcTest(CarsController.class)
class CarsControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	CarsService service;
	
	@Test
	void testingGetAll() throws Exception {
		mockMvc.perform(
				get("/api/v1/car/all")
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk());
	}
	@Test
	void testingSaveCar() throws Exception {
		
		String json = mapper.writeValueAsString(getValidCar());
		mockMvc.perform(
				post("/api/v1/car/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());
	}
	
	@Test
	void testingUpdateCar() throws Exception {
		String json = mapper.writeValueAsString(getValidCar());
		mockMvc.perform(
				put("/api/v1/car/{carId}",1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isNoContent());
	}
	@Test
	void testingRemoveCar() throws Exception {
		mockMvc.perform(delete("/api/v1/car/{carId}",1L).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	Cars getValidCar() {
		return new Cars();
	}
}
