package com.Trabalho.mensal.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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


}
