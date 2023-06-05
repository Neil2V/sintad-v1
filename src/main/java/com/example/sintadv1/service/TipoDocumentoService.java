package com.example.sintadv1.service;

import com.example.sintadv1.model.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

    TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento);

    List<TipoDocumento> getAllTipoDocumento();

    void deleteTipoDocumento(Long id);

    boolean existsById(Long id);

    TipoDocumento findById(Long id);
}
