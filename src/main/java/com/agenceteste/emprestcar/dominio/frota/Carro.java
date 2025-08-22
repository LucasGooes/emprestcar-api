package com.agenceteste.emprestcar.dominio.frota;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Carro {
	
	private Integer id;
	private String modelo;
	private String marca;
	private LocalDate dataFabricacao;
	private StatusCarro status;
	private Long kilometragem;
	private List<Revisao> revisoes;

	public Carro(Integer id,String modelo, String marca, LocalDate dataFabricacao, Long kilometragem) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.status = StatusCarro.INICIAL;
		this.kilometragem = kilometragem;
	}
	
	public Carro(String modelo, String marca, LocalDate dataFabricacao, Long kilometragem) {
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.status = StatusCarro.INICIAL;
		this.kilometragem = kilometragem;
	}
	
	public void alocarCarro() {
		this.status = StatusCarro.EM_USO;
	}
	
	public void levarAManutencao() {
		this.status = StatusCarro.EM_MANUTENCAO;
	}
	
	public void indisponibilizar() {
		this.status = StatusCarro.INDISPONIVEL;
	}

	public Integer getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public StatusCarro getStatus() {
		return status;
	}

	public Long getKilometragem() {
		return kilometragem;
	}

	public List<Revisao> getRevisoes() {
		return revisoes;
	}
	
}
