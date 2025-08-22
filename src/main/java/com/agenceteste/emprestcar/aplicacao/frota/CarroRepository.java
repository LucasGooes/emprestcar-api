package com.agenceteste.emprestcar.aplicacao.frota;

import java.util.List;
import java.util.UUID;

import com.agenceteste.emprestcar.dominio.frota.Carro;

public interface CarroRepository {
	
	Carro salvar(Carro caro);
	
	void indisponibilizar(UUID idCarro);
	
	List<Carro> listarTodos();

}
