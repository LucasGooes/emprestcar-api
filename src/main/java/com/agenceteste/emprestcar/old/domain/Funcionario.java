package com.agenceteste.emprestcar.old.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer matricula;
	
	@OneToMany(mappedBy = "carro")
	private List<Viagem> viagens = new ArrayList<>();
	
	protected Funcionario() {
	}
	
	public Funcionario(Integer id, String nome, Integer matricula) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getMatricula() {
		return matricula;
	}
	
	@JsonIgnore
	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
	
}
