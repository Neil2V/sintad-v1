package com.example.sintadv1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
public class EntidadDto {

    @NotNull
    private String nro_documento;

    @NotNull
    private String razon_social;

    private String nombre_comercial;

    private String direccion;

    private String telefono;

    @NotNull
    private boolean estado;

    private Long id_tipo_contribuyente;

    @NotNull
    private Long id_tipo_documento;
}
