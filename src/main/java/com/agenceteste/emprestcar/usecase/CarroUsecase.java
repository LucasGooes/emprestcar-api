package com.agenceteste.emprestcar.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Carro;
import com.agenceteste.emprestcar.repository.CarroRepository;

@Service
public class CarroUsecase {
	
	@Autowired
	private CarroRepository repo;

	public List<Carro> listarTodos() {
		return repo.findAll(); 
	}
	
	public void inserir(Carro carro) {
		repo.save(carro);
	}
	
}
