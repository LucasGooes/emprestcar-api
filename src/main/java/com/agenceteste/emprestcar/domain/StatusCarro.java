package com.agenceteste.emprestcar.domain;

public enum StatusCarro {
	
	LIBERADO(1, "Liberado para Emprestimo"),
	EM_USO(2, "Em uso");
	
	private int cod;
	private String descricao;
	
	private StatusCarro(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusCarro toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusCarro x : StatusCarro.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido! :"+cod);
	}
}
