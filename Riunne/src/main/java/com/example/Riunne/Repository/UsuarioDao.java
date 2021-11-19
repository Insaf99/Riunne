package com.example.Riunne.Repository;

import com.example.Riunne.Dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);
}
