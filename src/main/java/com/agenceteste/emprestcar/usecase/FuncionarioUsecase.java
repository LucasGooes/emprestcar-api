package com.agenceteste.emprestcar.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	public void deletar(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("NÃO É POSSÍVEL EXCLUIR FUNCIONARIO QUE TENHA EMPRESTIMOS RELACIONADOS!");
		}
	}

}
