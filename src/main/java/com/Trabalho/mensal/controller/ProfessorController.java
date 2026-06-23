package com.Trabalho.mensal.controller;

import com.Trabalho.mensal.model.Professor;
import com.Trabalho.mensal.repository.ProfessorRepository;
import com.Trabalho.mensal.service.ProfessorService;
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
@RequestMapping("/api/professor")
@RequiredArgsConstructor
@Tag(name = "Professores", description = "Gerenciamento de Professores da instituicao")
public class ProfessorController {

        private final ProfessorService service;

        @GetMapping
        @Operation(summary = "Listar todos os professores", description = "Mostra todos os professores ja cadastrados")
        public List<Professor> listar() {
            return service.ListarProfessores();
        }

        @GetMapping("/{id}")
        @Operation(summary = "Buscar por ID", description = "Retorna o professor que foi informado o id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Professor encontrado com sucesso"),
                @ApiResponse(responseCode = "404", description = "Professor não encontrado")
        })
        public ResponseEntity<Professor> BuscarPorId(@PathVariable long id) {
            return service.BuscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        @Operation(summary = "Cadastro de Professores")
        public ResponseEntity<Professor> cadastrar( @Valid @RequestBody Professor professor) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(professor));
        }

        @PutMapping("/{id}")
        @Operation(summary = "Atualizar dados do professor")
        public ResponseEntity<Professor> atualizar(@PathVariable Long id, @Valid @RequestBody Professor professor) {
            return service.atualizar(id, professor)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Remover Professor da lista")
        public ResponseEntity<Void> remover(@PathVariable Long id) {
            return service.excluir(id)
                    ? ResponseEntity.noContent().build()
                    : ResponseEntity.notFound().build();
        }
}
