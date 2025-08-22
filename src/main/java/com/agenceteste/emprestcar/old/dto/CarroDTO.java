package com.agenceteste.emprestcar.old.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.agenceteste.emprestcar.dominio.frota.Carro;
import com.agenceteste.emprestcar.infra.frota.CarroEntityJPA;

public class CarroDTO {
	
	private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String marca;
	@NotNull
	//@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	private LocalDate dataFabricacao;
	
	public CarroDTO() {
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
	
	public Carro toCarro() {
		return new Carro(modelo, marca, dataFabricacao, 0L);
	}
	
}
