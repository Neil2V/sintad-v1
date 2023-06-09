package com.example.sintadv1.service;

import com.example.sintadv1.model.TipoContribuyente;

import java.util.List;
import java.util.Optional;

public interface TipoContribuyenteService {

    TipoContribuyente saveTipoContribuyente(TipoContribuyente tipoContribuyente);

    List<TipoContribuyente> getAllTipoContribuyente();

    void deleteTipoContribuyente(Long id);

    boolean existsById(Long id);

    TipoContribuyente findById(Long id);

    Optional<TipoContribuyente> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
