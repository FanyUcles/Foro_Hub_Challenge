package com.alura.challenge.ForoHub.Service;

import com.alura.challenge.ForoHub.DTO.DatosRegistroRespuestas;
import com.alura.challenge.ForoHub.Model.Respuestas;
import com.alura.challenge.ForoHub.Model.Topicos;
import com.alura.challenge.ForoHub.Model.Usuarios;
import com.alura.challenge.ForoHub.Repository.IRespuestaRepository;
import com.alura.challenge.ForoHub.Repository.ITopicoRepository;
import com.alura.challenge.ForoHub.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private IRespuestaRepository respuestaRepo;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ITopicoRepository topicoRepo;

    @Transactional
    public Respuestas registrarServicio(DatosRegistroRespuestas datosRegistroRespuesta) {

        Long topicoId = datosRegistroRespuesta.topicoId();
        Topicos topico = topicoRepo.findById(topicoId).orElseThrow(() -> new IllegalArgumentException("El curso con ID " + topicoId + " no existe"));

        Long autorId = datosRegistroRespuesta.autorId();
        Usuarios autor = usuarioRepository.findById(autorId)
                .orElseThrow(() -> new IllegalArgumentException("El autor con ID " + autorId + " no existe."));

        Respuestas respuestas = new Respuestas(datosRegistroRespuesta, autor, topico);
        return respuestaRepo.save(respuestas);
    }

    public Page<Respuestas> getRespuestasPorTopico(Long topicoId, Pageable pageable) {
        return respuestaRepo.findByTopicoId(topicoId, pageable);
    }

    public void marcarRespuestaComoSolucion(Long idRespuesta) {
        Respuestas respuestas = respuestaRepo.findById(idRespuesta)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada para el ID: " + idRespuesta));

        respuestas.darRespuestaComoSolucion();

        respuestaRepo.save(respuestas);
    }

    public void desmarcarRespuestaComoSolucion(Long idRespuesta) {
        Respuestas respuestas = respuestaRepo.findById(idRespuesta)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada para el ID: " + idRespuesta));

        respuestas.desmarcarRespuestaComoSolucion();

        respuestaRepo.save(respuestas);
    }

}
