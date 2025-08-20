package com.agenceteste.emprestcar.old.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenceteste.emprestcar.old.security.JWTUtil;
import com.agenceteste.emprestcar.old.security.UserSS;
import com.agenceteste.emprestcar.old.security.UserService;

@RestController
@RequestMapping(value = "api/v1/auth")
public class AutenticacaoRest {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

}
