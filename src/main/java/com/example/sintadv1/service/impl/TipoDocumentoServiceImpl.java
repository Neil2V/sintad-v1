package com.example.sintadv1.service.impl;

import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.repository.TipoDocumentoRepository;
import com.example.sintadv1.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public List<TipoDocumento> getAllTipoDocumento() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public void deleteTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoDocumentoRepository.existsById(id);
    }

    @Override
    public TipoDocumento findById(Long id) {
        return tipoDocumentoRepository.findById(id).get();
    }

    @Override
    public Optional<TipoDocumento> findByCodigo(String codigo) {
        return tipoDocumentoRepository.findByCodigo(codigo);
    }

    public boolean existsByCodigo(String codigo){
        return tipoDocumentoRepository.existsByCodigo(codigo);
    }
}
