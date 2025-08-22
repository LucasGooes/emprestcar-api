package com.agenceteste.emprestcar.dominio.frota.repository;

import java.util.List;
import java.util.UUID;

import com.agenceteste.emprestcar.dominio.frota.Carro;

public interface CarroRepository {
	
	Carro salvar(Carro caro);
	
	void indisponibilizar(UUID idCarro);
	
	List<Carro> listarTodos();

}
