package com.agenceteste.emprestcar.old.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenceteste.emprestcar.old.domain.Viagem;
import com.agenceteste.emprestcar.old.usecase.ViagemUsecase;

@RestController
@RequestMapping(value = "/api/v1/viagem")
public class ViagemRest {
	
	@Autowired
	private ViagemUsecase viagemUsecase;
	
	@RequestMapping( value="realizadas/{mes}/{ano}", method = RequestMethod.GET)
	public ResponseEntity<List<Viagem>> listarViagensConcluidasEm(@PathVariable Integer mes, @PathVariable Integer ano) {
		List<Viagem> viagens = viagemUsecase.listarViagensConcluidasEm(mes, ano);
		return ResponseEntity.ok().body(viagens);
	}
	
	@RequestMapping( value="/{idFuncionario}/{idCarro}", method = RequestMethod.POST)
	public ResponseEntity<Void> ralizarRetirada(@PathVariable Integer idFuncionario, @PathVariable Integer idCarro) {
		Viagem obj = viagemUsecase.realizarRetirada(idFuncionario, idCarro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping( value="/{idFuncionario}/{idCarro}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> ralizarDevolucao(@PathVariable Integer idFuncionario, @PathVariable Integer idCarro) {
		viagemUsecase.realizarDevolucao(idFuncionario, idCarro);
		return ResponseEntity.ok().build();
	}
	
}
