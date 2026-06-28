package com.Trabalho.mensal.service;

import com.Trabalho.mensal.model.AreaConhecimento;
import com.Trabalho.mensal.repository.AreaConhecimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AreaConhecimentoService {

    private final AreaConhecimentoRepository areaConhecimentoRepository;

    public List<AreaConhecimento> ListarAreaConhecimento()
    {return areaConhecimentoRepository.findAll();}

    public Optional<AreaConhecimento> BuscarPorID(@PathVariable Long id)
    {return areaConhecimentoRepository.findById(id);}

    @Transactional
    public AreaConhecimento salvar(AreaConhecimento areaConhecimento){
        return areaConhecimentoRepository.save(areaConhecimento);
    }

    @Transactional
    public Optional<AreaConhecimento> atualizar(Long id,AreaConhecimento areaConhecimentoDetails){
        return areaConhecimentoRepository.findById(id).map(areaConhecimento ->  {
            areaConhecimento.setNome(areaConhecimentoDetails.getNome());
            return areaConhecimentoRepository.save(areaConhecimento);
        });
    }

    @Transactional
    public Boolean deletar(Long id){
        return areaConhecimentoRepository.findById(id).map(areaConhecimento ->  {
            areaConhecimentoRepository.delete(areaConhecimento);
            return true;
        }).orElse(false);
    }
}
