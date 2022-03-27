package com.agenceteste.emprestcar.repository;

import java.time.LocalDate;
import java.util.List;

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
	
	@Query("SELECT DISTINCT viagem FROM Viagem viagem "
			+ "WHERE viagem.status = 2 "
			+ "AND viagem.dataEntrega BETWEEN :dataInicial AND :dataFinal")
	List<Viagem> listarViagensComDataRetiradaEntre(@Param(value = "dataInicial") LocalDate dataInicial, @Param(value = "dataFinal") LocalDate dataFinal);
}
