package com.agenceteste.emprestcar.old.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.old.domain.Carro;
import com.agenceteste.emprestcar.old.domain.StatusCarro;
import com.agenceteste.emprestcar.old.repository.CarroRepository;
import com.agenceteste.emprestcar.old.usecase.exceptions.DataIntegrityException;
import com.agenceteste.emprestcar.old.usecase.exceptions.ObjectNotFoundException;

@Service
public class CarroUsecase {
	
	@Autowired
	private CarroRepository repo;
	
	public Carro buscarPorId(Integer id) {
		Optional<Carro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Carro não encontrado! Id: " + id + ", Tipo: " + Carro.class.getName()));
	}

	public List<Carro> listarTodos() {
		return repo.findAll(); 
	}
	
	public Carro inserir(Carro carro) {
		Carro obj = repo.save(carro);
		return obj;
	}
	
	public void deletar(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir carros que tenham emprestimos relacionados!");
		}
	}
	
	public List<Carro> listarCarrosEmUso() {
		return repo.findByStatus(StatusCarro.EM_USO.getCod());
	}

	public void atualizarStatus(Carro carro, StatusCarro status) {
		carro.setStatus(status);
		repo.save(carro);
	}
}
