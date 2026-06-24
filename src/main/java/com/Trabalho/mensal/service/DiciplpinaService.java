package com.Trabalho.mensal.service;

import com.Trabalho.mensal.model.Diciplina;
import com.Trabalho.mensal.repository.DiciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;


@Service
@RequiredArgsConstructor
public class DiciplpinaService {
    private final DiciplinaRepository repository;

    public DiciplpinaService(DiciplinaRepository repository) {
        this.repository = repository;
    }

    public List<Diciplina> ListarDiciplina() { return repository.findAll(); }

    public Optional<Diciplina> BuscarPorId(Long id) { return repository.findById(id); }

    @Transactional
    public Diciplina salvar( Diciplina diciplina ) { return repository.save(diciplina); }

    @Transactional
    public Optional<Diciplina> atualizar (Long id , Diciplina diciplinaDetails){
        return repository.findById(id).map( diciplina ->{
            diciplina.SetNome(diciplinaDetails.getNome());
            return repository.save(diciplina);
        });
    }

    @Transactional
    public Boolean excluir (long id) {
        return repository.findById(id).map( diciplina ->{
            repository.delete(diciplina);
            return true;

        }).orElse(false );
    }

}
