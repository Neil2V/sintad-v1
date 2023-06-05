package com.example.sintadv1.service;

import com.example.sintadv1.model.Entidad;
import com.example.sintadv1.model.TipoContribuyente;

import java.util.List;

public interface EntidadService {

    Entidad saveEntidad(Entidad entidad);

    List<Entidad> getAllEntidades();

    void deleteEntidad(Long id);

    boolean existsById(Long id);

    Entidad findById(Long id);
}
