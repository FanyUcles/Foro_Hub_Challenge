package com.alura.challenge.ForoHub.Service;

import com.alura.challenge.ForoHub.DTO.DatosRegistroTopico;
import com.alura.challenge.ForoHub.Tipos.Categoria;
import com.alura.challenge.ForoHub.Model.Cursos;
import com.alura.challenge.ForoHub.Model.Respuestas;
import com.alura.challenge.ForoHub.Model.Topicos;
import com.alura.challenge.ForoHub.Model.Usuarios;
import com.alura.challenge.ForoHub.Repository.ICursoRepository;
import com.alura.challenge.ForoHub.Repository.ITopicoRepository;
import com.alura.challenge.ForoHub.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private ITopicoRepository topicoRepository;

    @Autowired
    private ICursoRepository cursoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Transactional
    public Topicos registrarTopico(DatosRegistroTopico datosRegistroTopico) {
        // Verificar si el curso existe
        Long cursoId = datosRegistroTopico.cursoId();
        Cursos cursos = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("El curso con ID " + cursoId + " no existe."));
        System.out.println("Curso encontrado: " + cursos);

        // Verificar si el autor existe
        Long autorId = datosRegistroTopico.autorId();
        Usuarios autor = usuarioRepository.findById(autorId)
                .orElseThrow(() -> new IllegalArgumentException("El autor con ID " + autorId + " no existe."));
        System.out.println("Autor encontrado: " + autor);

        // Verificar si ya existe un tópico con el mismo título y mensaje
        List<Topicos> topicos = topicoRepository.findAll();
        for (Topicos topico : topicos) {
            if (topico.getTitulo().equalsIgnoreCase(datosRegistroTopico.titulo())
                    && topico.getMensaje().equalsIgnoreCase(datosRegistroTopico.mensaje())) {
                System.out.println("Ya existe un tópico con ese título y mensaje");
                return null; // O puedes lanzar una excepción
            }
        }

        // Si no se encuentra ningún tópico con el mismo título y mensaje, crea y guarda uno nuevo
        Topicos nuevoTopico = new Topicos(datosRegistroTopico, autor, cursos);
        Topicos topicoGuardado = topicoRepository.save(nuevoTopico);
        System.out.println("Tópico guardado: " + topicoGuardado);

        return topicoGuardado;
    }


    private static final Logger logger = LoggerFactory.getLogger(TopicoService.class);

    public List<Topicos> buscarPorCategoriaYSubcategoria(Categoria categoria, String subcategoria) {
        logger.info("Buscando temas para categoría {} y subcategoría {}", categoria, subcategoria);
        // Aquí va la lógica para buscar los temas
        List<Topicos> temas = topicoRepository.findByCategoriaAndSubcategoria(categoria, subcategoria);
        logger.info("Encontrados {} temas para categoría {} y subcategoría {}", temas.size(), categoria, subcategoria);
        return temas;
    }

    public Boolean tieneRespuestaComoSolucion(Topicos get) {
        Topicos topico = topicoRepository.getReferenceById(get.getId());
        Boolean resultado = false;
        for (Respuestas respuestas : topico.getRespuestas()) {
            if (respuestas.getSolucion().equals(Boolean.TRUE)) {
                resultado = true;
            }
        }
        return resultado;
    }

    public Boolean perteneceAlUsuario(Topicos topico) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("-----" + authentication);
        if (authentication == null || !authentication.isAuthenticated()) {
            return false; // Si no hay autenticación, no pertenece al usuario en sesión

        }

        String nombreUsuarioAutenticado = authentication.getName();
        // Comparar el nombre del usuario autenticado con el nombre del autor del tópico
        System.out.println("----- Nombre----- " + nombreUsuarioAutenticado);
        System.out.println("----- Resultado ----- "+ topico.getAutor().getUsername().equals(nombreUsuarioAutenticado));
        return topico.getAutor().getUsername().equals(nombreUsuarioAutenticado);
    }

    public Topicos obtenerTopicoPorId(Long id) {
        Topicos topico = topicoRepository.findById(id).get();
        return topico;
    }
}
