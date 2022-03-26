package com.agenceteste.emprestcar.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.agenceteste.emprestcar.domain.Carro;

public class CarroDTO {
	
	private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//@Length(min = 1, max = 240, message = "O Campo modelo deve ser preenchido")
	@NotEmpty
	private String modelo;
	//@Length(min = 1, max = 240, message = "O Campo marca deve ser preenchido")
	@NotEmpty
	private String marca;
	@NotNull
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	private String dataFabricacao;
	
	public CarroDTO() {
	}
	
	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}
	
	public Carro toCarro() {
		return new Carro(null, this.getModelo(), this.getMarca(), LocalDate.parse(this.getDataFabricacao(), formato));
	}
	
}
