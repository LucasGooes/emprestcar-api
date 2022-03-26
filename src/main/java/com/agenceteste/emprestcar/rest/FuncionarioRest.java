package com.agenceteste.emprestcar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenceteste.emprestcar.domain.Funcionario;
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

}
