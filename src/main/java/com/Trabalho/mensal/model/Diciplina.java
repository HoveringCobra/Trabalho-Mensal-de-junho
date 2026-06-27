package com.Trabalho.mensal.model;


import com.Trabalho.mensal.controller.CursosController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "diciplina")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Diciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Nome da Diciplina é obrigatorio ")
    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    @NotNull(message = "O curso é obrigatório")
    private Cursos curso;

}
