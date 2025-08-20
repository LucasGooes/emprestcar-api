package com.agenceteste.emprestcar.old.dto;

import javax.validation.constraints.NotEmpty;

import com.agenceteste.emprestcar.old.domain.Funcionario;

public class FuncionarioDTO {
	
	@NotEmpty
	private String nome;
	@NotEmpty
	private String matricula;
	
	public FuncionarioDTO() {
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public Funcionario toFuncionario() {
		return new Funcionario(null, this.getNome(), Integer.parseInt(this.getMatricula()));
	}

}
