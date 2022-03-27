package com.agenceteste.emprestcar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenceteste.emprestcar.usecase.ViagemUsecase;

@RestController
@RequestMapping(value = "/api/v1/viagem")
public class ViagemRest {
	
	@Autowired
	private ViagemUsecase viagemUsecase;
	
	@RequestMapping( value="/{idFuncionario}/{idCarro}", method = RequestMethod.POST)
	public ResponseEntity<Void> ralizarRetirada(@PathVariable Integer idFuncionario, @PathVariable Integer idCarro) {
		viagemUsecase.realizarRetirada(idFuncionario, idCarro);
		return ResponseEntity.ok().build();
	}
}
