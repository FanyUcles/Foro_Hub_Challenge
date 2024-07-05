package com.alura.challenge.ForoHub.Service;

import com.alura.challenge.ForoHub.DTO.DatosRegistroUsuario;
import com.alura.challenge.ForoHub.Model.Usuarios;
import com.alura.challenge.ForoHub.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    public Usuarios registrarUsuario(DatosRegistroUsuario datosRegistroUsuario) {

        Usuarios usuario = new Usuarios(datosRegistroUsuario);
        return usuarioRepo.save(usuario);
    }

    public Usuarios obtenerPorCorreoElectronico(String username) {
        return (Usuarios) usuarioRepo.findByCorreoElectronico(username);
    }
}
