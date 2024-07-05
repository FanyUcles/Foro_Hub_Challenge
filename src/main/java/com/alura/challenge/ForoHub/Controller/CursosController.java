package com.alura.challenge.ForoHub.Controller;

import com.alura.challenge.ForoHub.DTO.DatosListadoCurso;
import com.alura.challenge.ForoHub.DTO.DatosRegistroCurso;
import com.alura.challenge.ForoHub.Model.Cursos;
import com.alura.challenge.ForoHub.Repository.ICursoRepository;
import com.alura.challenge.ForoHub.Service.CursoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

 @RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class CursosController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ICursoRepository cursoRepo;

    @PostMapping("/registrar")
    public ResponseEntity registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println(datosRegistroCurso.subcategoria());
        Cursos cursos = cursoService.registrarCurso(datosRegistroCurso);
        System.out.println(cursos.getSubcategoria());
        DatosRegistroCurso datosRespuesta = new DatosRegistroCurso(
                cursos.getNombre(),
                cursos.getCategoriaPrincipal(),
                cursos.getSubcategoria());

        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(cursos.getId()).toUri();

        return ResponseEntity.created(url).body(datosRegistroCurso);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DatosListadoCurso>> listarCursos(
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable paginacion) {

        Page<Cursos> curso = cursoRepo.findByStatusTrue(paginacion);
        Page<DatosListadoCurso> datosListadoCurso = curso.map(DatosListadoCurso::new);
        return ResponseEntity.ok().body(datosListadoCurso);
    }
}
