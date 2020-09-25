package br.com.gustavoakira.master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.entities.Cars;
import br.com.gustavoakira.master.repository.CarRepository;

@Service
public class CarsService{
	
	@Autowired
	private CarRepository repository;
	
	public List<Cars> getCars(){
		return repository.findAll();
	}
	
	public Cars getCar(Long id) {
		return repository.getOne(id);
	}
	
	public Cars saveCar(Cars car, Long id) {
		if(id != 0) {
			car.setId(id);
		}
		return repository.save(car);
	}
	
	public String removeCar(Long id) {
		repository.deleteById(id);
		return "Ok";
	}
}
