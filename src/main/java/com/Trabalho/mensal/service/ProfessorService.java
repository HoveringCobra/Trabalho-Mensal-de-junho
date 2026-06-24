package com.Trabalho.mensal.service;

import com.Trabalho.mensal.model.Professor;
import com.Trabalho.mensal.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;


    public List<Professor> ListarProfessores() {
        return repository.findAll();
    }

    public Optional<Professor> BuscarPorId(long id) {
        return repository.findById(id);
    }

    @Transactional
    public Professor salvar(Professor professor) {
        return repository.save(professor);
    }

    @Transactional
    public Optional<Professor> atualizar(Long id, Professor professorDetails) {
        return repository.findById(id).map(professor -> {
            professor.setNome(professorDetails.getNome());
            professor.setEmail(professorDetails.getEmail());
            return repository.save(professor);
        });
    }
    @Transactional
    public Boolean excluir(long id) {
        return repository.findById(id).map(professor -> {
            repository.delete(professor);
            return true;
        }).orElse(false);
    }

}
