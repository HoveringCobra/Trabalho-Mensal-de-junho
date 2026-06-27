package com.Trabalho.mensal.service;


import com.Trabalho.mensal.model.Cursos;
import com.Trabalho.mensal.repository.CursosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursosService {

    private final CursosRepository cursosRepository;

    public List<Cursos> listarTodos() { return cursosRepository.findAll(); }

    public Optional<Cursos> buscarPorId(Long id){ return cursosRepository.findById(id); }

    @Transactional
    public Cursos salvar(Cursos cursos) {
        return cursosRepository.save(cursos);
    }
    @Transactional
    public Optional<Cursos> atualizar(Long id, Cursos cursosDetails) {
        return cursosRepository.findById(id).map(curso -> {
            curso.setNome(cursosDetails.getNome());
            curso.setProfessor(cursosDetails.getProfessor());
            return cursosRepository.save(curso);
        });
    }

    @Transactional
    public boolean remover(Long id) {
        return cursosRepository.findById(id).map( cursos -> {
            cursosRepository.delete(cursos);
            return true;
        }).orElse(false);
    }
}
