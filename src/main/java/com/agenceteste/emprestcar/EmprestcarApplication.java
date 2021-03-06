package com.agenceteste.emprestcar;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.agenceteste.emprestcar.domain.User;
import com.agenceteste.emprestcar.repository.UserRepository;

@SpringBootApplication
public class EmprestcarApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(EmprestcarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("admin", pe.encode("fleetmg@!"));
		
		userRepository.saveAll(Arrays.asList(user));
	}

}
