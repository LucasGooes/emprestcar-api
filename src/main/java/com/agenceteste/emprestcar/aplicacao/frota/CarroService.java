package com.agenceteste.emprestcar.aplicacao.frota;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.dominio.frota.Carro;

@Service
public class CarroService {
	
	private CarroRepository repository;

	public CarroService(CarroRepository repository) {
		this.repository = repository;
	}

	public Carro salvar(Carro caro) {
		return repository.salvar(caro);
	}
	
	public List<Carro> listarTodos() {
		return repository.listarTodos();
	}

	public void indisponibilizar(UUID idCarro) {
		repository.indisponibilizar(idCarro);
	}

}
