package com.agenceteste.emprestcar.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.dto.FuncionarioDTO;
import com.agenceteste.emprestcar.usecase.FuncionarioUsecase;

@RestController
@RequestMapping(value = "/api/v1/funcionarios")
public class FuncionarioRest {

	@Autowired
	private FuncionarioUsecase funcionarioUsecase;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> listarTodos() {
		List<Funcionario> funcionarios = funcionarioUsecase.listarTodos();
		return ResponseEntity.ok().body(funcionarios);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody @Valid FuncionarioDTO novo) {
		Funcionario funcionario = novo.toFuncionario();
		funcionarioUsecase.inserir(funcionario);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		funcionarioUsecase.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
