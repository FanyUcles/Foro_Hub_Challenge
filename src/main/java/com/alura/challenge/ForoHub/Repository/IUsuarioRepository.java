package com.alura.challenge.ForoHub.Repository;

import com.alura.challenge.ForoHub.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Long>{

    public UserDetails findByCorreoElectronico(String username);

}
