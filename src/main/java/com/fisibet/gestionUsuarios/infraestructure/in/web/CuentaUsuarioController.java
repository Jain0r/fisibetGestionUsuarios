package com.fisibet.gestionUsuarios.infraestructure.in.web;

import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.ActualizarCuentaUsuarioCommand;
import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.ActualizarCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.RegistrarCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.domain.CuentaUsuario;
import com.fisibet.gestionUsuarios.infraestructure.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
public class CuentaUsuarioController {

    private final RegistrarCuentaUsuarioPort cuentaUsuarioPort;
    private final ActualizarCuentaUsuarioPort actualizarCuentaUsuarioPort;

    public CuentaUsuarioController(RegistrarCuentaUsuarioPort cuentaUsuarioPort, ActualizarCuentaUsuarioPort actualizarCuentaUsuarioPort) {
        this.cuentaUsuarioPort = cuentaUsuarioPort;
        this.actualizarCuentaUsuarioPort = actualizarCuentaUsuarioPort;
    }

    @PostMapping(path = "/cuentaUsuario/registrar")
    public void registrarUsuario(@RequestBody CuentaUsuario cuentaUsuario){
        cuentaUsuarioPort.registrarCuentaUsuario(cuentaUsuario);
    }

    @PostMapping(path = "/cuentaUsuario/actualizarIdUsuario")
    public void actualizarIdUsuario(@RequestBody ActualizarCuentaUsuarioCommand command){
        actualizarCuentaUsuarioPort.actualizarCuentaUsuario(command);
    }


}
