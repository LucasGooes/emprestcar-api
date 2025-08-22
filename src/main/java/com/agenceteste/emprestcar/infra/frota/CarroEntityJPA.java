package com.agenceteste.emprestcar.infra.frota;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.agenceteste.emprestcar.old.domain.StatusCarro;
import com.agenceteste.emprestcar.old.domain.Viagem;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carro")
public class CarroEntityJPA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String modelo;
	private String marca;
	private LocalDate dataFabricacao;
	private Integer status;
	/*
	@OneToMany(mappedBy = "carro")
	private List<Viagem> viagens = new ArrayList<>();
	*/
	protected CarroEntityJPA() {
	}
	
	public CarroEntityJPA(Integer id, String modelo, String marca, LocalDate dataFabricacao) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.status = StatusCarro.LIBERADO.getCod();
	}
	
	public Integer getId() {
		return id;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public LocalDate getData() {
		return dataFabricacao;
	}
	
	public StatusCarro getStatus() {
		return StatusCarro.toEnum(status);
	}

	public void setStatus(StatusCarro status) {
		this.status = status.getCod();
	}
/*
	@JsonIgnore
	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
*/
}
