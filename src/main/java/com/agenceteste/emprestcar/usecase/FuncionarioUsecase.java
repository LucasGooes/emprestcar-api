package com.agenceteste.emprestcar.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.repository.FuncionarioRepository;
import com.agenceteste.emprestcar.usecase.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioUsecase {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario buscarPorId(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"OBJETO NÃO ENCONTRADO! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
	
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
