package br.com.ecommerce.usuario.repository;

import br.com.ecommerce.usuario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
    Optional<UsuarioModel> findByEmail(String email);
}
