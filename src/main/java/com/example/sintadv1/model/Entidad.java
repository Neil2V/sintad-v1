package com.example.sintadv1.model;

import com.example.sintadv1.service.EntidadService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_entidad")
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    private Long id;

    private String nro_documento;

    private String razon_social;

    private String nombre_comercial;

    private String direccion;

    private String telefono;

    private boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_contribuyente")
    private TipoContribuyente tipoContribuyente;


    public Entidad(String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, boolean estado) {
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }
}
