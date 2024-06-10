package com.example.WizardsWands_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.WizardsWands_sb.entity.Usuario;

@EnableJpaRepositories
@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

}