package com.agenceteste.emprestcar.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.repository.FuncionarioRepository;
import com.agenceteste.emprestcar.usecase.exceptions.DataIntegrityException;
import com.agenceteste.emprestcar.usecase.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioUsecase {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario buscarPorId(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Funcionário não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
	
	public List<Funcionario> listarTodos() {
		return repo.findAll();
	}
	
	public Funcionario inserir(Funcionario funcionario) {
		Funcionario obj = repo.save(funcionario);
		return obj;
	}
	
	public void deletar(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir funcionários que tenham emprestimos relacionados!");
		}
	}

}
