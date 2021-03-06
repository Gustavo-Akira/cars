package br.com.gustavoakira.master.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavoakira.master.dto.BrandDTO;
import br.com.gustavoakira.master.service.BrandService;



@WebMvcTest(BrandController.class)
class BrandControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	BrandService brandService;
	
	@Test
	void testGetBrands() throws Exception {
		given(brandService.getAll()).willReturn(List.of(new BrandDTO("")));
		mockMvc.perform(get("/api/v1/brand/all")
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	void testNewBrand() throws Exception {
		String json  = objectMapper.writeValueAsString(new BrandDTO("carros"));
		mockMvc.perform(post("/api/v1/brand/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isCreated());
	}
	
	@Test
	void testUpdateBrand() throws Exception {
		String json  = objectMapper.writeValueAsString(new BrandDTO("carros1"));
		mockMvc.perform(put("/api/v1/brand/{brandId}",1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	void testDeleteBrand() throws Exception{
		mockMvc.perform(delete("/api/v1/brand/{brandId}",1L)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
}
