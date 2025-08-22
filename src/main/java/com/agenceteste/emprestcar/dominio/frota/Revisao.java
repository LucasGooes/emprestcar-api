package com.agenceteste.emprestcar.dominio.frota;

import java.time.LocalDate;
import java.util.UUID;

public class Revisao {
	
    private UUID uuid;
    private LocalDate dataAgendada;
    private Integer kmAgendada;
    private boolean emergencia;
    private boolean concluida;
	
    public Revisao(LocalDate dataAgendada, Integer kmAgendada, boolean emergencia, boolean concluida) {
		this.uuid = UUID.randomUUID();
    	this.dataAgendada = dataAgendada;
		this.kmAgendada = kmAgendada;
		this.emergencia = emergencia;
		this.concluida = concluida;
	}

	public UUID getUuid() {
		return uuid;
	}

	public LocalDate getDataAgendada() {
		return dataAgendada;
	}

	public Integer getKmAgendada() {
		return kmAgendada;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public boolean isConcluida() {
		return concluida;
	}
    

}
