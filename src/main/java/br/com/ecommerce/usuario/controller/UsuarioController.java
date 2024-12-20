package br.com.ecommerce.usuario.controller;

import br.com.ecommerce.usuario.model.UsuarioModel;
import br.com.ecommerce.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<UsuarioModel> registrar(@RequestBody UsuarioModel usuarioModel) {
        usuarioService.registrar(usuarioModel);
        return ResponseEntity.ok().body(usuarioModel);
    }

}
