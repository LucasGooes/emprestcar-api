package com.agenceteste.emprestcar.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Carro;
import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.domain.StatusCarro;
import com.agenceteste.emprestcar.domain.Viagem;
import com.agenceteste.emprestcar.repository.ViagemRepository;

@Service
public class ViagemUsecase {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private CarroUsecase carroUsecase;
	
	@Autowired
	private FuncionarioUsecase funcUsecase;
	
	public void realizarRetirada(Integer idFuncionario, Integer idCarro) {
		Carro carro = carroUsecase.buscarPorId(idCarro);
		if(!carro.getStatus().equals(StatusCarro.LIBERADO)) {
			//VERIFICAR COMO SE PODE MELHORAR ESSA EXCEÇÃO
			throw new RuntimeException("CARRO NÃO ESTA LIBERADO PARA USO");
		}
		Funcionario funcionario = funcUsecase.buscarPorId(idFuncionario);
		Viagem viagem = new Viagem(null, funcionario, carro);
		viagemRepository.save(viagem);
		carroUsecase.carroEmUso(carro);
	}
	
}
