package br.com.gustavoakira.master.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavoakira.master.entities.Brand;
import br.com.gustavoakira.master.repository.BrandRepository;
import javassist.NotFoundException;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository repository;
	
	@Transactional(readOnly = true)
	public List<Brand> getAll(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Brand getOne(Long id) {
		return repository.getOne(id);
	}
	
	@Transactional()
	public Brand saveBrand(Brand brand, Long id) throws NotFoundException {
		if(id != 0) {
			if(this.getOne(id) == null) {
				throw new NotFoundException("brand with id "+id);
			}else {
				brand.setId(id);
			}
		}
		return repository.save(brand);
	}
	
	@Transactional
	public String removeBrand(Long id) throws NotFoundException{
		if(repository.findById(id).isEmpty()) {
			throw new NotFoundException("brand with id:"+id);
		}
		return "Ok";
	}
}
