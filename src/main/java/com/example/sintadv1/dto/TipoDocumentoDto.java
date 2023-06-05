package com.example.sintadv1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
public class TipoDocumentoDto {

    @NotNull
    private String codigo;

    @NotNull
    private String nombre;

    private String descripcion;

    private boolean estado;
}
