package com.Trabalho.mensal.controller;

import com.Trabalho.mensal.model.Cursos;
import com.Trabalho.mensal.service.CursosService;
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
@RequestMapping("/api/curso")
@RequiredArgsConstructor
@Tag(name = "Cursos", description = "Gerenciamento de cursos da instituição")
public class CursosController {

    private final CursosService cursosService;

    @GetMapping
    @Operation(summary = "Lista todos os cursos", description = "Retorna a lista de todos os cursos com seus respectivos representantes")
    public List<Cursos> listarTodos() {
        return cursosService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar curso po ID", description = "Retorna od detalhes de um curso específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")

    })
    public ResponseEntity<Cursos> buscarPorId(@PathVariable long id) {
        return cursosService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cdastrar novo Curso")
    public ResponseEntity<Cursos> cadastrar(@Valid @RequestBody Cursos cursos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursosService.salvar(cursos));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados de um curso")
    public ResponseEntity<Cursos> atualizar(@PathVariable Long id, @Valid @RequestBody Cursos cursos) {
      return cursosService.atualizar(id, cursos)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover curso do sistema")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return cursosService.remover(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
