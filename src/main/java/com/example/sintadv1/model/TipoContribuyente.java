package com.example.sintadv1.model;

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
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    private Long id;

    private String nombre;

    private boolean estado;


    public TipoContribuyente(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
}
