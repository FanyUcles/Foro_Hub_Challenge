package com.alura.challenge.ForoHub.DTO;

import com.alura.challenge.ForoHub.Model.Cursos;
import com.alura.challenge.ForoHub.Model.Topicos;
import com.alura.challenge.ForoHub.Model.Usuarios;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosListadoTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        Boolean status,
        @NotNull
        Usuarios autor,
        @NotNull
        Cursos cursos) {

    public DatosListadoTopico(Topicos topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCursos());
    }
}
