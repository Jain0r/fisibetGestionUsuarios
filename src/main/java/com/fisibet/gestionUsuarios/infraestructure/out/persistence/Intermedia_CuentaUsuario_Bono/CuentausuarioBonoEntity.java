package com.fisibet.gestionUsuarios.infraestructure.out.persistence.Intermedia_CuentaUsuario_Bono;

import com.fisibet.gestionUsuarios.infraestructure.out.persistence.BonoPersistence.BonoEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.CuentaUsuarioPersistence.CuentaUsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cuentausuario_bono")
public class CuentausuarioBonoEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "idCuentaUsuario")
    private CuentaUsuarioEntity cuentaUsuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "idBono")
    private BonoEntity bono;
}
