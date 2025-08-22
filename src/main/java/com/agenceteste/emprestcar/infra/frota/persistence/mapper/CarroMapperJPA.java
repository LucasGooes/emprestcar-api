package com.agenceteste.emprestcar.infra.frota.persistence.mapper;

import org.springframework.stereotype.Component;

import com.agenceteste.emprestcar.dominio.frota.Carro;
import com.agenceteste.emprestcar.infra.frota.persistence.entity.CarroEntityJPA;

@Component
public class CarroMapperJPA {
	
    public CarroEntityJPA toEntity(Carro carro) {
        return new CarroEntityJPA(carro.getId(), carro.getModelo(), carro.getMarca(), carro.getDataFabricacao());
    }
    
    public Carro toDomain(CarroEntityJPA entity) {
    	return new Carro(entity.getId() ,entity.getMarca(), entity.getModelo(), entity.getDataFabricacao(), 0L);
    }

}
