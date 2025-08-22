package com.agenceteste.emprestcar.aplicacao.frota;

import com.agenceteste.emprestcar.dominio.frota.Carro;

public interface GerenciadorStatusCarro {
	
	boolean verificarStatusDisponivel(Carro carro);

}
