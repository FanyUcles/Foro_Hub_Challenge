package com.alura.challenge.ForoHub.Service;

import com.alura.challenge.ForoHub.DTO.DatosRegistroCurso;
import com.alura.challenge.ForoHub.Model.Cursos;
import com.alura.challenge.ForoHub.Repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private ICursoRepository cursoRepo;

    public Cursos registrarCurso(DatosRegistroCurso datosRegistroCurso){
        Cursos cursos = new Cursos(datosRegistroCurso);

        return cursoRepo.save(cursos);
    }
}
