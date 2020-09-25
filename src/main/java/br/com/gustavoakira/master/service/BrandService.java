package br.com.gustavoakira.master.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavoakira.master.dto.BrandDTO;
import br.com.gustavoakira.master.entities.Brand;
import br.com.gustavoakira.master.repository.BrandRepository;
import javassist.NotFoundException;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository repository;
	
	@Transactional(readOnly = true)
	public List<BrandDTO> getAll(){
		return repository.findAll().stream().map(x -> new BrandDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public BrandDTO getOne(Long id) {
		return new BrandDTO(repository.getOne(id));
	}
	
	@Transactional()
	public BrandDTO saveBrand(BrandDTO brandDTO, Long id) throws NotFoundException {
		Brand brand = new Brand(brandDTO);
		if(id != 0) {
			if(this.getOne(id) == null) {
				throw new NotFoundException("brand with id "+id);
			}else {
				brand.setId(id);
			}
		}
		return new BrandDTO(repository.save(brand));
	}
	
	@Transactional
	public String removeBrand(Long id) throws NotFoundException{
		if(repository.findById(id).isEmpty()) {
			throw new NotFoundException("brand with id:"+id);
		}
		return "Ok";
	}
}
