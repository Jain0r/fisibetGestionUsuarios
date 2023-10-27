package com.fisibet.gestionUsuarios.infraestructure.out.persistence.CuentaUsuarioPersistence;


import com.fisibet.gestionUsuarios.infraestructure.out.persistence.BilleteraVirtualPersistence.BilleteraVirtualEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.TarjetaPersistence.TarjetaEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.TipoUsuarioPersistence.TipoUsuarioEntity;
import com.fisibet.gestionUsuarios.infraestructure.out.persistence.UsuarioPersistence.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cuenta_usuario")
public class CuentaUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String correo;

    private String contrasenia;

    private String registered;

    private String updated;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuarioEntity tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "idBilleterVirtual")
    private BilleteraVirtualEntity billeteraVirtual;

    @OneToMany(mappedBy = "cuentaUsuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TarjetaEntity> tarjetas;

    public CuentaUsuarioEntity(int id){
        this.id = id;
    }

}
    //@OneToOne
    //private Usuario usuario;


