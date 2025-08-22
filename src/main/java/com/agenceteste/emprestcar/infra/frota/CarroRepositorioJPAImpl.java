package com.agenceteste.emprestcar.infra.frota;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.agenceteste.emprestcar.aplicacao.frota.CarroRepository;
import com.agenceteste.emprestcar.dominio.frota.Carro;

@Repository
public class CarroRepositorioJPAImpl implements CarroRepository {
	
	private CarroRepositoryJPA repositorioJPA;
	private CarroMapperJPA mapper;

	public CarroRepositorioJPAImpl(CarroRepositoryJPA repositorioJPA, CarroMapperJPA mapper) {
		this.repositorioJPA = repositorioJPA;
		this.mapper = mapper;
	}

	@Override
	public Carro salvar(Carro caro) {
		return mapper.toDomain(repositorioJPA.save(mapper.toEntity(caro)));
	}

	@Override
	public void indisponibilizar(UUID idCarro) {
		
	}

	@Override
	public List<Carro> listarTodos() {
		return repositorioJPA.findAll().stream().map(entity -> mapper.toDomain(entity)).collect(Collectors.toList());
	}

}
