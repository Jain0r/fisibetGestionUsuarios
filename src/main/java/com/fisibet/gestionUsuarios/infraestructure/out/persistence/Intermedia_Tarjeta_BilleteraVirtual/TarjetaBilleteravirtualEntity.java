package com.fisibet.gestionUsuarios.infraestructure.out.persistence.Intermedia_Tarjeta_BilleteraVirtual;

import com.fisibet.gestionUsuarios.application.common.UseCase;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.BilleteraVirtualPersistence.BilleteraVirtualEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.BonoPersistence.BonoEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.CuentaUsuarioPersistence.CuentaUsuarioEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.TarjetaPersistence.TarjetaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tarjeta_billeteravirtual")
public class TarjetaBilleteravirtualEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "idTarjeta")
    private TarjetaEntity tarjeta;

    @Id
    @ManyToOne
    @JoinColumn(name = "idBilleteraVirtual")
    private BilleteraVirtualEntity billeteraVirtual;
}
