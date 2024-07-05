package com.alura.challenge.ForoHub.Repository;

import com.alura.challenge.ForoHub.Model.Respuestas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuestas, Long>{

    public Page<Respuestas> findByStatusTrue(Pageable paginacion);

    Page<Respuestas> findByTopicoId(Long topicoId, Pageable pageable);


}