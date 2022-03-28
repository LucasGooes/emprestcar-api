package com.agenceteste.emprestcar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.agenceteste.emprestcar.domain.Carro;
import com.agenceteste.emprestcar.domain.Funcionario;
import com.agenceteste.emprestcar.domain.StatusCarro;
import com.agenceteste.emprestcar.domain.User;
import com.agenceteste.emprestcar.domain.Viagem;
import com.agenceteste.emprestcar.repository.CarroRepository;
import com.agenceteste.emprestcar.repository.FuncionarioRepository;
import com.agenceteste.emprestcar.repository.UserRepository;
import com.agenceteste.emprestcar.repository.ViagemRepository;

@SpringBootApplication
public class EmprestcarApplication implements CommandLineRunner {

	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(EmprestcarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Carro carro = new Carro(null, "Pulse", "Fiat", LocalDate.parse( "20/09/2021", formato));
		Carro carro2 = new Carro(null, "Golf", "Volkswagen", LocalDate.parse( "15/04/2018", formato));
		Carro carro3 = new Carro(null, "HB20", "Hyundai", LocalDate.parse( "01/12/2019", formato));
		
		Funcionario func = new Funcionario(null, "Roberto", 001);
		Funcionario func2 = new Funcionario(null, "Fabiola", 002);
		Funcionario func3 = new Funcionario(null, "Hortencia", 003);
		Funcionario func4 = new Funcionario(null, "Lucas", 004);
		Funcionario func5 = new Funcionario(null, "João", 005);

		Viagem viagem = new Viagem(null, func, carro);
		carro.setStatus(StatusCarro.EM_USO);
		Viagem viagem2 = new Viagem(null, func2, carro2);
		carro2.setStatus(StatusCarro.EM_USO);
		
		User user = new User("admin", pe.encode("fleetmg@!"));
		
		carroRepository.saveAll(Arrays.asList(carro, carro2, carro3));
		funcionarioRepository.saveAll(Arrays.asList(func, func2, func3, func4, func5));		
		viagemRepository.saveAll(Arrays.asList(viagem, viagem2));
		userRepository.saveAll(Arrays.asList(user));
	}

}
