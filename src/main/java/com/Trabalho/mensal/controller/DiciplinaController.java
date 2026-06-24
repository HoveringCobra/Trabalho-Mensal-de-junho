package com.Trabalho.mensal.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diciplina")
@RequiredArgsConstructor
@Tag(name = "diciplina", description = "Gerenciamento de Dicíplinas da Instituição" )
public class DiciplinaController {
}
