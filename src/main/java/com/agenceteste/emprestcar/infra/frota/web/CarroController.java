package com.agenceteste.emprestcar.infra.frota.web;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenceteste.emprestcar.aplicacao.frota.service.CarroService;
import com.agenceteste.emprestcar.dominio.frota.Carro;
import com.agenceteste.emprestcar.old.dto.CarroDTO;

@RestController
@RequestMapping(value = "/api/v1/carros")
public class CarroController {
	
	private CarroService service;
	
	public CarroController(CarroService service) {
		this.service = service;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Carro>> listarTodos() {
		return ResponseEntity.ok().body(service.listarTodos());
	}
	/*
	@RequestMapping( value="/retirados", method = RequestMethod.GET)
	public ResponseEntity<List<CarroEntity>> listarCarrosEmUso() {
		List<CarroEntity> carros = carroUsecase.listarCarrosEmUso();
		return ResponseEntity.ok().body(carros);
	}
	*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody @Valid CarroDTO novo) {
		Carro carro = service.salvar(novo.toCarro());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	/*
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		carroUsecase.deletar(id);
		return ResponseEntity.noContent().build();
	}
	*/
}
