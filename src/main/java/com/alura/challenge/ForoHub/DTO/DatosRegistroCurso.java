package com.alura.challenge.ForoHub.DTO;

import com.alura.challenge.ForoHub.Tipos.Categoria;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(

        @NotBlank(message = "El nombre es obligatorio") String nombre,
        Categoria categoriaPrincipal,
        String subcategoria
) {
}
