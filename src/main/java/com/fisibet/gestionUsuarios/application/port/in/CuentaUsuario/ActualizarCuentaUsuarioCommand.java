package com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarCuentaUsuarioCommand {
    String correoABuscar;

    int nuevoIdUsuario;
}
