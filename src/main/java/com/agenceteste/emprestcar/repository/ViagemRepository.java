package com.agenceteste.emprestcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenceteste.emprestcar.domain.Carro;

@Repository
public interface ViagemRepository extends JpaRepository<Carro, Integer> {

}
