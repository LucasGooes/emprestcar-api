package com.agenceteste.emprestcar.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.domain.Carro;
import com.agenceteste.emprestcar.domain.StatusCarro;
import com.agenceteste.emprestcar.repository.CarroRepository;
import com.agenceteste.emprestcar.usecase.exceptions.ObjectNotFoundException;

@Service
public class CarroUsecase {
	
	@Autowired
	private CarroRepository repo;
	
	public Carro buscarPorId(Integer id) {
		Optional<Carro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"OBJETO NÃO ENCONTRADO! Id: " + id + ", Tipo: " + Carro.class.getName()));
	}

	public List<Carro> listarTodos() {
		return repo.findAll(); 
	}
	
	public void inserir(Carro carro) {
		repo.save(carro);
	}
	
	public void deletar(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("NÃO É POSSÍVEL EXCLUIR CARROS QUE TENHAM EMPRESTIMOS RELACIONADOS!");
		}
	}
	
	public List<Carro> listarCarrosEmUso() {
		return repo.findByStatus(StatusCarro.EM_USO.getCod());
	}

	public void carroEmUso(Carro carro) {
		carro.setStatus(StatusCarro.EM_USO);
		repo.save(carro);
	}
}
