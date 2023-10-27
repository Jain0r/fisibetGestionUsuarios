package com.fisibet.gestionUsuarios.application.service;

import com.fisibet.gestionUsuarios.application.common.UseCase;
import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.ActualizarCuentaUsuarioCommand;
import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.ActualizarCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.RegistrarCuentaUsuarioCommand;
import com.fisibet.gestionUsuarios.application.port.in.CuentaUsuario.RegistrarCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.application.port.out.CuentaUsuario.LoadCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.application.port.out.CuentaUsuario.SaveCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.application.port.out.CuentaUsuario.UpdateCuentaUsuarioPort;
import com.fisibet.gestionUsuarios.domain.CuentaUsuario;
import jakarta.transaction.Transactional;

@UseCase
public class RegistrarCuentaUsuarioService implements RegistrarCuentaUsuarioPort, ActualizarCuentaUsuarioPort {
    private final LoadCuentaUsuarioPort loadCuentaUsuarioPort;
    private final UpdateCuentaUsuarioPort updateCuentaUsuarioPort;

    private final SaveCuentaUsuarioPort saveCuentaUsuarioPort;

    public RegistrarCuentaUsuarioService(LoadCuentaUsuarioPort loadCuentaUsuarioPort, UpdateCuentaUsuarioPort updateCuentaUsuarioPort, SaveCuentaUsuarioPort saveCuentaUsuarioPort) {
        this.loadCuentaUsuarioPort = loadCuentaUsuarioPort;
        this.updateCuentaUsuarioPort = updateCuentaUsuarioPort;
        this.saveCuentaUsuarioPort = saveCuentaUsuarioPort;
    }


    @Transactional
    @Override
    public boolean registrarCuentaUsuario(CuentaUsuario registrarCuentaUsuario) {
        try{
            CuentaUsuario cuentaUsuario = loadCuentaUsuarioPort.loadByCorreo(registrarCuentaUsuario.getCorreo());

            if (cuentaUsuario == null){

                saveCuentaUsuarioPort.save(registrarCuentaUsuario);

            } else {
                throw new RuntimeException("Cuenta ya registrada, registre otro correo");
            }

            //updateCuentaUsuarioPort.updateCuentaUsuario(cuentaUsuario);
        } catch (Exception e){
            System.out.println("Error en RegistrarCuentaUsuarioService.registrarCuentaUsuario: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void actualizarCuentaUsuario(ActualizarCuentaUsuarioCommand command) {

        try{
            CuentaUsuario cuentaUsuario = loadCuentaUsuarioPort.loadByCorreo(command.getCorreoABuscar());

            if(cuentaUsuario == null){
                throw new RuntimeException("no se encontro correo de cuenta");
            }
            cuentaUsuario.actualizarIdUsuarioXcorreo(command.getNuevoIdUsuario());

            updateCuentaUsuarioPort.updateCuentaUsuario(cuentaUsuario);

        } catch (Exception e){
            System.out.println("Error en RegistrarCuentaUsuarioService.actualizarCuentaUsuario: " + e.getMessage());
        }

    }
}
