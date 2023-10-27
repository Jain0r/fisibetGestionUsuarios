package com.fisibet.gestionUsuarios.infraestructure.out.persistence.TarjetaPersistence;

import com.fisibet.gestionUsuarios.infraestructure.out.persistence.CuentaUsuarioPersistence.CuentaUsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tarjeta")
public class TarjetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;

    private String numero;

    private String csv;

    private String fechaVencimiento;

    private String registered;

    private String updated;

    @ManyToOne
    @JoinColumn(name ="id")
    private CuentaUsuarioEntity cuentaUsuario;
}
