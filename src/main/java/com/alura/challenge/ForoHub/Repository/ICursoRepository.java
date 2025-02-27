package com.alura.challenge.ForoHub.Repository;

import com.alura.challenge.ForoHub.Model.Cursos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Cursos, Long>{

    public Page<Cursos> findByStatusTrue(Pageable paginacion);

}