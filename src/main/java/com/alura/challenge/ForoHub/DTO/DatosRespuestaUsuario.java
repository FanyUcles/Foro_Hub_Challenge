package com.alura.challenge.ForoHub.DTO;

import com.alura.challenge.ForoHub.Tipos.TipoPerfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaUsuario(

        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotNull
        TipoPerfil perfil) {

}
