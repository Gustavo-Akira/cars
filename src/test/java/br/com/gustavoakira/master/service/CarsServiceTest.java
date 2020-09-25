package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavoakira.master.entities.Brand;
import br.com.gustavoakira.master.entities.Cars;

@SpringBootTest
class CarsServiceTest {
	
	@Autowired
	private CarsService service;
	
	@Test
	void testingNewCar() {
		Cars car = new Cars(1L,"Carros",new Brand(1L,"aaa"),Instant.ofEpochSecond(12220));
		car = service.saveCar(car, 0L);
		assertNotEquals(null , car);
	}
	
	@Test
	void testinggetAllCars() {
		List<Cars> cars = service.getCars();
		assertNotEquals(null, cars);
	}
	
	@Test
	void testinggetCar() {
		Cars car = service.getCar(1L);
		assertNotEquals(null, car);
	}
	
	@Test
	void testingSaveCar() {
		Cars car = new Cars(0L,"Carros",new Brand(1L,"aaa"),Instant.ofEpochSecond(12220));
		car = service.saveCar(car, 1L);
		assertNotEquals(null , car);
	}
	
	@Test
	void testingRemoveCar() {
		String result = service.removeCar(1L);
		assertEquals("Ok",result);
	}
}
