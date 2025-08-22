package com.agenceteste.emprestcar.aplicacao.frota.usecase;

import com.agenceteste.emprestcar.dominio.frota.Carro;
import com.agenceteste.emprestcar.dominio.frota.StatusCarro;

public class GerenciadorStatusCarroImpl implements GerenciadorStatusCarro {

	@Override
	public boolean verificarStatusDisponivel(Carro carro) {
		if (carro.getStatus().equals(StatusCarro.DISPONIVEL)) {
			return true;
		}
		return false;
	}

}
