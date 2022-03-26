package com.agenceteste.emprestcar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenceteste.emprestcar.domain.Carro;
import com.agenceteste.emprestcar.usecase.CarroUsecase;

@RestController
@RequestMapping(value = "/api/v1/carros")
public class CarroRest {
	
	@Autowired
	private CarroUsecase carroUsecase;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Carro>> listarTodos() {
		List<Carro> carros = carroUsecase.listarTodos();
		return ResponseEntity.ok().body(carros);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Carro novo) {
		carroUsecase.inserir(novo);
		return ResponseEntity.ok().build();
	}

}
