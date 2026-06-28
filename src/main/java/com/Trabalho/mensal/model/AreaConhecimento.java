package com.Trabalho.mensal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "area de conhecimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaConhecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da Area de conhecimento e obrigatório")
    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    @NotNull(message = "O id do curso e Obrigatório")
    private Cursos curso;



}
