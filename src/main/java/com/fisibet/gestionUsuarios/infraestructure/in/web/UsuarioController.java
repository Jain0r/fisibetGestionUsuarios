package com.fisibet.gestionUsuarios.infraestructure.in.web;

import com.fisibet.gestionUsuarios.application.port.in.Usuario.RegistrarUsuarioPort;
import com.fisibet.gestionUsuarios.domain.Usuario;
import com.fisibet.gestionUsuarios.infraestructure.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
public class UsuarioController {

    private final RegistrarUsuarioPort registrarUsuarioPort;


    public UsuarioController(RegistrarUsuarioPort registrarUsuarioPort) {
        this.registrarUsuarioPort = registrarUsuarioPort;
    }

    @PostMapping(path = "/usuario/registrar")
    public void registrarUsuario(@RequestBody Usuario usuario){
        registrarUsuarioPort.registrarUsuario(usuario);
    }
}
