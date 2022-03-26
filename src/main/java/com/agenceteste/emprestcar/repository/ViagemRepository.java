package com.agenceteste.emprestcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenceteste.emprestcar.domain.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

}
