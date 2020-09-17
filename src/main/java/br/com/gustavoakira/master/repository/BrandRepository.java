package br.com.gustavoakira.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavoakira.master.entities.Brand;

@Repository
public interface BrandRepository  extends JpaRepository<Brand, Long>{
	
}
