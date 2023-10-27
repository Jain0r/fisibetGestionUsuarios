package com.fisibet.gestionUsuarios.infraestructure.out.persistence.CuentaUsuarioPersistence;

import com.fisibet.gestionUsuarios.domain.CuentaUsuario;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.BilleteraVirtualPersistence.BilleteraVirtualEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.TipoUsuarioPersistence.TipoUsuarioEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.UsuarioPersistence.UsuarioEntity;

public class CuentaUsuarioMapper {

    public static CuentaUsuario entityToDomain (CuentaUsuarioEntity cuentaUsuarioEntity){
        CuentaUsuario cuentaUsuario = new CuentaUsuario();
        cuentaUsuario.setIdCuentaUsuario(cuentaUsuarioEntity.getId());
        cuentaUsuario.setCorreo(cuentaUsuarioEntity.getCorreo());
        cuentaUsuario.setContrasenia(cuentaUsuarioEntity.getContrasenia());
        cuentaUsuario.setRegistered(cuentaUsuarioEntity.getRegistered());
        cuentaUsuario.setUpdated(cuentaUsuarioEntity.getUpdated());
        cuentaUsuario.setIdUsuario(cuentaUsuarioEntity.getUsuario().getIdUsuario());
        cuentaUsuario.setIdTipoUsuario(cuentaUsuarioEntity.getTipoUsuario().getId());
        cuentaUsuario.setIdBilleteraVirtual(cuentaUsuarioEntity.getBilleteraVirtual().getIdBilleteraVirtual());

        return cuentaUsuario;
    }

    public static CuentaUsuarioEntity domainToEntity(CuentaUsuario cuentaUsuario){
        CuentaUsuarioEntity cuentaUsuarioEntity = new CuentaUsuarioEntity();
        cuentaUsuarioEntity.setId(cuentaUsuario.getIdCuentaUsuario());
        cuentaUsuarioEntity.setCorreo(cuentaUsuario.getCorreo());
        cuentaUsuarioEntity.setContrasenia(cuentaUsuario.getContrasenia());
        cuentaUsuarioEntity.setRegistered(cuentaUsuario.getRegistered());
        cuentaUsuarioEntity.setUpdated(cuentaUsuario.getUpdated());
        cuentaUsuarioEntity.setUsuario(new UsuarioEntity(cuentaUsuario.getIdUsuario()));
        cuentaUsuarioEntity.setTipoUsuario(new TipoUsuarioEntity(cuentaUsuario.getIdTipoUsuario()));
        cuentaUsuarioEntity.setBilleteraVirtual(new BilleteraVirtualEntity(cuentaUsuario.getIdBilleteraVirtual()));

        return cuentaUsuarioEntity;
    }
}
