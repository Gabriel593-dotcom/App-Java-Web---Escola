package com.escola.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.escola.demo.model.Aluno;
import com.escola.demo.repository.AlunoRepository;
import com.escola.demo.service.AlunoService;

@Configuration
public class AlunoConfig implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoService alunoService;

	@Override
	public void run(String... args) throws Exception {

		Aluno aluno1 = new Aluno(null, "Gabriel", 21);
		Aluno aluno2 = new Aluno(null, "Ana", 19);
		Aluno aluno3 = new Aluno(null, "Ana", 19);
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
		alunoService.insert(aluno3);
	}

}
