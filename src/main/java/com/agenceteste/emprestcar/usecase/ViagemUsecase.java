package com.agenceteste.emprestcar.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenceteste.emprestcar.repository.ViagemRepository;

@Service
public class ViagemUsecase {
	
	@Autowired
	private ViagemRepository repo;

	
}
