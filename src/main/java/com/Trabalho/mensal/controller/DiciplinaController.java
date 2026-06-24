package com.Trabalho.mensal.controller;

import com.Trabalho.mensal.model.Diciplina;
import com.Trabalho.mensal.service.DiciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diciplina")
@RequiredArgsConstructor
@Tag(name = "diciplina", description = "Gerenciamento de Dicíplinas da Instituição" )
public class DiciplinaController {

    private final DiciplinaService service;

    @GetMapping("/{id}")
    @Operation(summary = "Listar todas as diciplinas", description = "Mostras todas as diciplinas já Cadastradas")
    public List<Diciplina> listar(){return service.ListarDiciplina();}
    @GetMapping
    @Operation(summary = "BUscar por ID", description = "Retornar a diciplina que foi informado o id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diciplina encontrada com sucesso "),
            @ApiResponse(responseCode = "404", description = "Diciplina nao encontrada" )
    })
    public ResponseEntity<Diciplina> BuscarPorId(@PathVariable long id ){
        return service.BuscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Diciplina da lista")
    public ResponseEntity<Void> remover(@PathVariable Long id ){
        return service.excluir(id)
                ?ResponseEntity.noContent().build()
                :ResponseEntity.notFound().build();
    }

}
