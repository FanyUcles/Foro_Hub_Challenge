package com.alura.challenge.ForoHub.Model;

import com.alura.challenge.ForoHub.DTO.DatosRegistroCurso;
import com.alura.challenge.ForoHub.Tipos.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Categoría principal del curso")
    private Categoria categoriaPrincipal;

    @Schema(description = "Subcategoría del curso: ",
            allowableValues = {
                    "(Java", "Swift", "Kotlin", "TypeScript", "Go", "PHP", "Python", "JavaScript", "C#", "C++", "Ruby", "HTML/CSS)",
                    "(Spring Framework", "React.js", "Angular", "Vue.js", "Express.js", "Django", "Quasar", "Flutter", ".NET Core", "Ruby on Rails", "Laravel)",
                    "(Frontend Development", "Backend Development", "Desarrollo Full Stack", "Arquitectura Web", "Seguridad Web", "Experiencia de Usuario (UX)", "Diseño Web)",
                    "(iOS Development", "Android Development", "Desarrollo Cross-Platform", "Diseño de Interfaz de Usuario Móvil (UI)", "Desarrollo de Juegos Móviles)",
                    "(Integración Continua / Entrega Continua (CI/CD)", "Administración de Sistemas", "Contenedores (Docker, Kubernetes)", "Gestión de Configuración (Ansible, Chef, Puppet)", "Monitoreo y Registro)",
                    "(MySQL", " PostegreSQL", "Microsoft SQL Server", "Oracle Database", "MongoDB", "MariaDB)",
                    "(Machine Learning", "Deep Learning", "Procesamiento del Lenguaje Natural (NLP)", "Visión por Computadora", "Análisis de Datos", "Minería de Datos)",
                    "(Ciberseguridad", "Ethical Hacking", "Auditoría de Seguridad", "Protección de Datos", "Criptografía)",
                    "(Desarrollo de Videojuegos", "Desarrollo de Software Empresarial", "Metodologías de Desarrollo Ágil", "Tutoriales y Recursos de Aprendizaje", "Carrera y Desarrollo Profesional)"
            },
            example = "Java")
    private String subcategoria;

    private Boolean status;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Topicos> topicos;

    public Cursos(DatosRegistroCurso registroCurso){
        this.nombre = registroCurso.nombre();
        this.categoriaPrincipal = registroCurso.categoriaPrincipal();
        this.subcategoria = registroCurso.subcategoria();
        this.status = true;
    }
}
