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

import br.com.gustavoakira.master.entities.Brand;
import br.com.gustavoakira.master.service.BrandService;
import javassist.NotFoundException;

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping()
	public ResponseEntity<List<Brand>> getBrands(){
		return new ResponseEntity<>(brandService.getAll(), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Brand> newBrand(@RequestBody Brand brand) throws NotFoundException{
		return new ResponseEntity<>(brandService.saveBrand(brand,0L),HttpStatus.CREATED);
	}
	
	@PutMapping("/{brandId}")
	public ResponseEntity<Brand> updateBrand(@PathVariable("brandId") Long brandId, @RequestBody Brand brand) throws NotFoundException{
		return new ResponseEntity<>(brandService.saveBrand(brand,brandId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{brandId}")
	public ResponseEntity<String> deleteBrand(@PathVariable("brandId") Long brandId) throws NotFoundException{
		return new ResponseEntity<>(brandService.removeBrand(brandId), HttpStatus.OK);
	}
}
