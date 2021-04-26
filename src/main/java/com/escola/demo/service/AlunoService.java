package com.escola.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.demo.model.Aluno;
import com.escola.demo.repository.AlunoRepository;
import com.escola.demo.service.exceptions.ResourceAlreadyExistsException;
import com.escola.demo.service.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {

		return alunoRepository.findAll();
	}

	public Aluno findById(Long id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void insert(Aluno aluno) {

		List<Aluno> filteredAluno = findAll().stream().filter(p -> p.equals(aluno)).collect(Collectors.toList());

		if (filteredAluno.isEmpty()) {
			alunoRepository.save(aluno);
		} else {
			System.out.println("Aluno já cadastrado. " + "(" + aluno.toString() + ")");
			throw new ResourceAlreadyExistsException();
		}

	}

	public void delete(Long id) {

		alunoRepository.deleteById(id);
	}
}
