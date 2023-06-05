package com.example.sintadv1.service.impl;

import com.example.sintadv1.model.Entidad;
import com.example.sintadv1.repository.EntidadRepository;
import com.example.sintadv1.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;
    @Override
    public Entidad saveEntidad(Entidad entidad) {
        return entidadRepository.save(entidad);
    }

    @Override
    public List<Entidad> getAllEntidades() {
        return entidadRepository.findAll();
    }

    @Override
    public void deleteEntidad(Long id) {
        entidadRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return entidadRepository.existsById(id);
    }

    @Override
    public Entidad findById(Long id) {
        return entidadRepository.findById(id).get();
    }
}
