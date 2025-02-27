package com.alura.challenge.ForoHub.Model;

import com.alura.challenge.ForoHub.DTO.DatosRegistroTopico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    private String titulo;
    private String mensaje;

    private LocalDateTime fechaCreacion;
    private Boolean status;
    private Boolean estaSolucionado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuarios autor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cursos cursos;

    @OneToMany(mappedBy = "topico")
    private List<Respuestas> respuestas;

    public Topicos(DatosRegistroTopico topicoDTO, Usuarios autor, Cursos cursos) {
        this.titulo = topicoDTO.titulo();
        this.mensaje = topicoDTO.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = autor;
        this.cursos = cursos;
        this.status = true;
        this.estaSolucionado = false;
    }

    public void actualizarDatos(DatosRegistroTopico.DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }

    public void activarTopico() {
        this.status = true;
    }


}