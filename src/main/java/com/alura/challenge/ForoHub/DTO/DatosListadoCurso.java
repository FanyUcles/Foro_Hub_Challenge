package com.alura.challenge.ForoHub.DTO;

import com.alura.challenge.ForoHub.Tipos.Categoria;
import com.alura.challenge.ForoHub.Model.Cursos;

public record DatosListadoCurso(

        String nombre,
        Categoria categoriaPrincipal,
        String subcategoria) {

    public DatosListadoCurso(Cursos cursos) {
        this(
                cursos.getNombre(),
                cursos.getCategoriaPrincipal(),
                cursos.getSubcategoria()
        );
    }
}
