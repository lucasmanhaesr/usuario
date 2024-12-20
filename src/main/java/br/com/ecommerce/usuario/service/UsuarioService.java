package br.com.ecommerce.usuario.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.ecommerce.usuario.model.UsuarioModel;
import br.com.ecommerce.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<UsuarioModel> registrar(UsuarioModel usuarioModel) {

        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findByEmail(usuarioModel.getEmail());
        if (usuarioOpt.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado");
        }

        usuarioModel.setId(UUID.randomUUID().toString().substring(0, 8));

        String password = usuarioModel.getSenha();
        String hashedPassword = BCrypt.withDefaults().hashToString(10, password.toCharArray());
        usuarioModel.setSenha(hashedPassword);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));

    }

}
