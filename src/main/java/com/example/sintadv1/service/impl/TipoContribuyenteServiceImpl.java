package com.example.sintadv1.service.impl;

import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.repository.TipoContribuyenteRepository;
import com.example.sintadv1.service.TipoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService {

    @Autowired
    private TipoContribuyenteRepository tipoContribuyenteRepository;
    @Override
    public TipoContribuyente saveTipoContribuyente(TipoContribuyente tipoContribuyente) {
        return tipoContribuyenteRepository.save(tipoContribuyente);
    }

    @Override
    public List<TipoContribuyente> getAllTipoContribuyente() {
        return tipoContribuyenteRepository.findAll();
    }

    @Override
    public void deleteTipoContribuyente(Long id) {
        tipoContribuyenteRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoContribuyenteRepository.existsById(id);
    }

    @Override
    public TipoContribuyente findById(Long id) {
        return tipoContribuyenteRepository.findById(id).get();
    }
}
