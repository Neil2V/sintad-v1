package com.example.sintadv1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TipoContribuyenteDto {

    @NotNull
    private String nombre;

    @NotNull
    private boolean estado;
}
