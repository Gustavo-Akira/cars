package br.com.gustavoakira.master.entities;

import java.time.Instant;

public class Cars {
	private Long id;
	private String name;
	private Brand brand;
	private Instant instant;
	
	
	
	public Cars() {
	}
	
	public Cars(Long id, String name, Brand brand, Instant instant) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.instant = instant;
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
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}
	
}
