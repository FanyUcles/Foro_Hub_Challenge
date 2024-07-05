package com.alura.challenge.ForoHub.Controller;

import com.alura.challenge.ForoHub.Model.Usuarios;
import com.alura.challenge.ForoHub.Security.TokenService;
import com.alura.challenge.ForoHub.Security.DatosAutenticacionUsuario;
import com.alura.challenge.ForoHub.Security.DatosJWTtoken;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTtoken> autenticarUsuario(@RequestBody DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correoElectronico(), datosAutenticacionUsuario.password());
        System.out.println("-----Token de Autenticación----- " + authenticationToken);
        Authentication usuarioAutenticado = authenticationManager.authenticate(authenticationToken);
        System.out.println("-----Usuario Autenticado----- "+ usuarioAutenticado);
        String tokenJWT = tokenService.generarToken((Usuarios) usuarioAutenticado.getPrincipal());
        System.out.println("-----Token JWT----- " + tokenJWT);
        DatosJWTtoken response = new DatosJWTtoken(tokenJWT, ((Usuarios) usuarioAutenticado.getPrincipal()).getNombre());
        System.out.println("-----Response----- "+ response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/redirect")
    public void redirectAfterLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }
}
