package com.agenceteste.emprestcar.old.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenceteste.emprestcar.old.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	public List<Carro> findByStatus(int status);
	

}
