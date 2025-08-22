package com.agenceteste.emprestcar.infra.frota.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenceteste.emprestcar.infra.frota.persistence.entity.CarroEntityJPA;

public interface CarroRepositoryJPA extends JpaRepository<CarroEntityJPA, Integer>{

}
