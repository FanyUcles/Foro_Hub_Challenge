package com.alura.challenge.ForoHub.Service;

import com.alura.challenge.ForoHub.DTO.DatosRegistroCurso;
import com.alura.challenge.ForoHub.Model.Curso;
import com.alura.challenge.ForoHub.Repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private ICursoRepository cursoRepo;

    public Curso registrarCurso(DatosRegistroCurso datosRegistroCurso){
        Curso curso = new Curso(datosRegistroCurso);

        return cursoRepo.save(curso);
    }
}
