package com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario;

import com.fisibet.gestionUsuarios.domain.CuentaUsuario;

public interface RegistrarCuentaUsuarioPort {

    public boolean registrarCuentaUsuario(CuentaUsuario registrarCuentaUsuarioCommand);
}
