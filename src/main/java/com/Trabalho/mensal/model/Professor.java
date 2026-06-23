package com.Trabalho.mensal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do Professor é obrigatorio")
    @Column(nullable = false, unique = true)
    private String nome;

    @NotBlank(message = "O Email do Professor é obrigatorio")
    @Column(nullable = false, unique = true)
    private String email;
}
