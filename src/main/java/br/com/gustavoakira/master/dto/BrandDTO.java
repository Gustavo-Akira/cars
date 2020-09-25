package br.com.gustavoakira.master.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import br.com.gustavoakira.master.entities.Brand;

public class BrandDTO {
	
	@Null
	private Long id;
	
	@NotNull
	private String name;
	
	public BrandDTO(String name) {
		this.name = name;
	}
	
	public BrandDTO(Brand brand) {
		this.name = brand.getName();
		this.id = brand.getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
}
