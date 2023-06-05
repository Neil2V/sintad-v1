package com.example.sintadv1.security.service;

import com.example.sintadv1.security.entity.Rol;
import com.example.sintadv1.security.enums.RolEnum;
import com.example.sintadv1.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> findByRolname(RolEnum rolname){
        return rolRepository.findByRolname(rolname);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
