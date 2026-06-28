package com.Trabalho.mensal.controller;

import com.Trabalho.mensal.model.AreaConhecimento;
import com.Trabalho.mensal.service.AreaConhecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areaConhecimento")
@RequiredArgsConstructor
@Tag(name = "Area de Conhecimento", description = "Gerenciamento de Area de Conhecimento da instituição")
public class AreaConhecimentoController {

    private final AreaConhecimentoService areaConhecimentoService;

    @GetMapping
    @Operation(summary = "Listar todas as areas de conhecimentos", description = "Mostras todas as areas de conhecimento ja cadastrados")
    public List<AreaConhecimento> listarAreaConhecimentos() {
        return areaConhecimentoService.ListarAreaConhecimento();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por id", description = "Mostra a area de conhecimento com o id informado")
    @ApiResponses(value =  {
            @ApiResponse(responseCode = "200", description = "Area de conhecimento encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Area de conhecimento não encontrada")
    })
    public ResponseEntity<AreaConhecimento> buscarAreaConhecimentoPorId(@PathVariable Long id) {
        return areaConhecimentoService.BuscarPorID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastro de Area de Conhecimento")
    public ResponseEntity<AreaConhecimento> cadastrar(@Valid @RequestBody AreaConhecimento areaConhecimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(areaConhecimentoService.salvar(areaConhecimento));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar area de conhecimento")
    public ResponseEntity<AreaConhecimento> atualizar(@PathVariable Long id, @Valid @RequestBody AreaConhecimento areaConhecimento) {
        return areaConhecimentoService.atualizar(id, areaConhecimento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir area de conhecimento")
    public ResponseEntity<AreaConhecimento> excluir(@PathVariable Long id) {
        return areaConhecimentoService.deletar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
