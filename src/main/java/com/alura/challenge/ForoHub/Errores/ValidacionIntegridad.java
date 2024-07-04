package com.alura.challenge.ForoHub.Errores;

public class ValidacionIntegridad extends RuntimeException {
    public ValidacionIntegridad(String s) {

        super(s);
    }
}