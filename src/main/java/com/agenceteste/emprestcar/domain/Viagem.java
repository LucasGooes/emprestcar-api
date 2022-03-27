package com.agenceteste.emprestcar.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataRetirada;
	private LocalDate dataEntrega;
	private Integer status;
	
	@ManyToOne
	@JoinColumn
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn
	private Carro carro;
	
	protected Viagem() {
	}
	
	public Viagem(Integer id, Funcionario funcionario, Carro carro) {
		this.id = id;
		this.dataRetirada = LocalDate.now();
		this.dataEntrega = null;
		this.funcionario = funcionario;
		this.carro = carro;
		this.status = StatusViagem.EM_CURSO.getCod();
	}
	
	public Integer getId() {
		return id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public Carro getCarro() {
		return carro;
	}
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusViagem getStatus() {
		return StatusViagem.toEnum(status);
	}

	public void setStatus(StatusViagem status) {
		this.status = status.getCod();
	}
	
}
