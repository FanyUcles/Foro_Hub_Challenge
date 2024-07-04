package com.alura.challenge.ForoHub.DTO;

import com.alura.challenge.ForoHub.Tipos.TipoPerfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(

        @NotBlank String nombre,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull TipoPerfil perfil
) {

    public static record DatosActualizarUsuario(
            @NotNull Long id,
            String nombre,
            String email,
            TipoPerfil perfil
    ){

    }
}
