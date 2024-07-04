package com.alura.challenge.ForoHub.Tipos;

public class TipoPerfil {

    ADMINISTRADOR("Administrador"),
    MODERADOR("Moderador"),
    ESTUDIANTE("Estudiante"),
    INSTRUCTOR("Instructor");

    private String nombre;

    TipoPerfil(String nombre){
        this.nombre = nombre;
    }
}