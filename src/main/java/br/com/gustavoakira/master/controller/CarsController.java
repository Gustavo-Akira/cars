package br.com.gustavoakira.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoakira.master.entities.Cars;
import br.com.gustavoakira.master.service.CarsService;

@RestController
@RequestMapping("/api/v1/car")
public class CarsController {
	@Autowired
	private CarsService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Cars>> getCars(){
		return new ResponseEntity<>(service.getCars(), HttpStatus.OK);
	}
	
	@GetMapping("{carId}")
	public ResponseEntity<Cars> getCar(@PathVariable("carId")Long carId){
		return new ResponseEntity<>(service.getCar(carId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cars> saveNewCar(@RequestBody Cars car){
		return new ResponseEntity<>(service.saveCar(car, 0L),HttpStatus.CREATED);
	}
	
	@PutMapping("{carId}")
	public ResponseEntity<Cars> saveChangeCar(@PathVariable("carId")Long carId, @RequestBody Cars car){
		return new ResponseEntity<>(service.saveCar(car, carId),HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{carId}")
	public ResponseEntity<String> removeCar(@PathVariable("carId")Long carId){
		return new ResponseEntity<>(service.removeCar(carId),HttpStatus.OK);
	}
}
