package com.agenceteste.emprestcar.domain;

public enum StatusViagem {
	
	EM_CURSO(1, "Em curso"),
	CONCLUIDA(2, "Concluida");
	
	private int cod;
	private String descricao;
	
	private StatusViagem(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusViagem toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusViagem x : StatusViagem.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido! :"+cod);
	}
}
