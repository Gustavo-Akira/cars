package br.com.gustavoakira.master;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.gustavoakira.master.entities.Brand;
import br.com.gustavoakira.master.service.BrandService;
import javassist.NotFoundException;

@SpringBootTest
class MasterApplicationTests {
	@Autowired
	private BrandService brandService;
	
	
	@Test
	void testingAddBrand() throws NotFoundException {
		Brand newBrand = new Brand(0L,"Wolchs");
		newBrand = brandService.saveBrand(newBrand,0L);
		assertNotEquals(null, newBrand);
	}
	
	@Test
	void testingGetAllBrands() {
		List<Brand> brands = brandService.getAll();
		assertNotEquals(null, brands);
	}

	
}
