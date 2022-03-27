package com.agenceteste.emprestcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agenceteste.emprestcar.domain.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Integer> {
	
	@Query("SELECT DISTINCT viagem FROM Viagem viagem "
			+ "WHERE viagem.status = :status "
			+ "AND viagem.carro.id = :idCarro "
			+ "AND viagem.funcionario.id = :idFuncionario")
	Viagem buscarViagemEspecifica(@Param(value = "status") Integer statusViagem, @Param(value = "idFuncionario") Integer idFuncionario, @Param(value = "idCarro") Integer idCarro);
	

}
