package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavoakira.master.dto.BrandDTO;
import javassist.NotFoundException;

@SpringBootTest
class BrandServiceTest {

	@Autowired
	private BrandService brandService;
	
	
	@Test
	void testingAddBrand() throws NotFoundException {
		BrandDTO newBrand = new BrandDTO("Wolchs");
		newBrand = brandService.saveBrand(newBrand,0L);
		assertNotEquals(null, newBrand);
	}
	
	@Test
	void testingGetAllBrands() {
		List<BrandDTO> brands = brandService.getAll();
		assertNotEquals(null, brands);
	}
	
	@Test
	void testingGetBrand() {
		BrandDTO brand = brandService.getOne(1L);
		assertNotEquals(null, brand);
	}
	
	@Test
	void testingRemoveBrand() throws NotFoundException {
		String result =brandService.removeBrand(1L);
		assertEquals("Ok", result);
	}
	
	
}
