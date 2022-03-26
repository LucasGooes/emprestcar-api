package com.agenceteste.emprestcar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenceteste.emprestcar.usecase.ViagemUsecase;

@RestController
@RequestMapping(value = "/api/v1/viagens")
public class ViagemRest {
	
	@Autowired
	private ViagemUsecase viagemUsecase;
		
}
