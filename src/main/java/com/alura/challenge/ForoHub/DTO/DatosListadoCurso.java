package com.alura.challenge.ForoHub.DTO;

import com.alura.challenge.ForoHub.Tipos.Categoria;
import com.alura.challenge.ForoHub.Model.Curso;

public record DatosListadoCurso(

        String nombre,
        Categoria categoriaPrincipal,
        String subcategoria) {

    public DatosListadoCurso(Curso curso) {
        this(
                curso.getNombre(),
                curso.getCategoriaPrincipal(),
                curso.getSubcategoria()
        );
    }
}
