package com.alura.challenge.ForoHub.Repository;

import com.alura.challenge.ForoHub.Tipos.Categoria;
import com.alura.challenge.ForoHub.Model.Topicos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ITopicoRepository extends JpaRepository<Topicos, Long> {

    Page<Topicos> findByStatusTrue(Pageable paginacion);

    @Query("SELECT t FROM Topico t WHERE t.curso.categoriaPrincipal = :categoriaPrincipal AND YEAR(t.fechaCreacion) = :anio")
    Page<Topicos> findByCursoCategoriaPrincipalAndAnio(@Param("categoriaPrincipal") Categoria categoriaPrincipal, @Param("anio") int anio, Pageable pageable);

    public Page<Topicos> findByFechaCreacionYear(int anio, Pageable pageable);

    @Query("SELECT t FROM Topico t "
            + "JOIN t.curso c "
            + "WHERE c.categoriaPrincipal = :categoria "
            + "AND c.subcategoria = :subcategoria")
    List<Topicos> findByCategoriaAndSubcategoria(@Param("categoria") Categoria categoria, @Param("subcategoria") String subcategoria);

    @Query(value = "SELECT * FROM topicos t JOIN respuestas r ON t.id = r.topico_id WHERE r.id = ?1", nativeQuery = true)
    Optional<Topicos> findByRespuestaId(Long respuestaId);

}
