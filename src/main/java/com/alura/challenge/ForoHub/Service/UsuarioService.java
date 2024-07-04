package com.alura.challenge.ForoHub.Service;

import com.alura.challenge.ForoHub.DTO.DatosRegistroUsuario;
import com.alura.challenge.ForoHub.Model.Usuario;
import com.alura.challenge.ForoHub.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    public Usuario registrarUsuario(DatosRegistroUsuario datosRegistroUsuario) {

        Usuario usuario = new Usuario(datosRegistroUsuario);
        return usuarioRepo.save(usuario);
    }

    public Usuario obtenerPorCorreoElectronico(String username) {
        return (Usuario) usuarioRepo.findByCorreoElectronico(username);
    }
}
