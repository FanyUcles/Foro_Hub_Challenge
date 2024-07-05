package com.alura.challenge.ForoHub.Tipos;

public enum TipoPerfil {

    administrador("Administrador"),
    moderador("Moderador"),
    estudante("Estudiante"),
    instructor("Instructor");

    private String nombre;

    TipoPerfil(String nombre){
        this.nombre = nombre;
    }
}