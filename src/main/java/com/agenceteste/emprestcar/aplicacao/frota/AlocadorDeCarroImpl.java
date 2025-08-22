package com.agenceteste.emprestcar.aplicacao.frota;

import com.agenceteste.emprestcar.dominio.frota.Carro;
import com.agenceteste.emprestcar.dominio.frota.StatusCarro;

public class AlocadorDeCarroImpl implements AlocadorDeCarro {

	private GerenciadorStatusCarro gerenciadorStatus;
	
	public AlocadorDeCarroImpl(GerenciadorStatusCarro gerenciadorStatus) {
		this.gerenciadorStatus = gerenciadorStatus;
	}

	@Override
	public Carro alocarCarro(Carro carro) {
		if (gerenciadorStatus.verificarStatusDisponivel(carro)) {
			carro.alocarCarro();
		}
		return carro;
	}

}
