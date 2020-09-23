package br.com.gustavoakira.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavoakira.master.entities.Cars;

@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {

}
