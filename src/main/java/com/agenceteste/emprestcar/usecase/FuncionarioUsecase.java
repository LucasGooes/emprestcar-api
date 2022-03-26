package com.agenceteste.emprestcar.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.repository.FuncionarioRepository;

@Service
public class FuncionarioUsecase {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public List<Funcionario> listarTodos() {
		return repo.findAll();
	}
	
	public void inserir(Funcionario funcionario) {
		repo.save(funcionario);
	}

}
