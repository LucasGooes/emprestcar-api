package com.agenceteste.emprestcar.usecase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Carro;
import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.domain.StatusCarro;
import com.agenceteste.emprestcar.domain.StatusViagem;
import com.agenceteste.emprestcar.domain.Viagem;
import com.agenceteste.emprestcar.repository.ViagemRepository;
import com.agenceteste.emprestcar.usecase.exceptions.BusinessException;

@Service
public class ViagemUsecase {

	@Autowired
	private ViagemRepository viagemRepository;

	@Autowired
	private CarroUsecase carroUsecase;

	@Autowired
	private FuncionarioUsecase funcUsecase;
	
	public List<Viagem> listarViagensConcluidasEm(Integer mes, Integer ano) {
		LocalDate dataInicial = LocalDate.of(ano, mes, 1);
		LocalDate dataFinal = LocalDate.of(ano, mes, dataInicial.lengthOfMonth());
		List<Viagem> viagens = viagemRepository.listarViagensComDataRetiradaEntre(dataInicial, dataFinal);
		return viagens;
	}

	public Viagem realizarRetirada(Integer idFuncionario, Integer idCarro) {
		Carro carro = carroUsecase.buscarPorId(idCarro);
		if (!carro.getStatus().equals(StatusCarro.LIBERADO)) {
			throw new BusinessException("Este carro não esta liberado para uso! Id: "+idCarro);
		}
		Funcionario funcionario = funcUsecase.buscarPorId(idFuncionario);
		Viagem viagem = new Viagem(null, funcionario, carro);
		Viagem obj = viagemRepository.save(viagem);
		carroUsecase.atualizarStatus(carro, StatusCarro.EM_USO);
		return obj;
	}

	public void realizarDevolucao(Integer idFuncionario, Integer idCarro) {
		Viagem viagem = viagemRepository.buscarViagemEspecifica(StatusViagem.EM_CURSO.getCod(), idFuncionario, idCarro);
		if(viagem == null) {
			throw new BusinessException("Não foi encontrada uma viagem cos os determinados parâmetros!");
		}
		viagem.setDataEntrega(LocalDate.now());
		viagem.setStatus(StatusViagem.CONCLUIDA);
		viagemRepository.save(viagem);
		Carro carro = carroUsecase.buscarPorId(idCarro);
		carroUsecase.atualizarStatus(carro, StatusCarro.LIBERADO);
	}
	
	

}
