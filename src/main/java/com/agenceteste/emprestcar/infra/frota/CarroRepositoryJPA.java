package com.agenceteste.emprestcar.infra.frota;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarroRepositoryJPA extends JpaRepository<CarroEntityJPA, UUID>{

}
