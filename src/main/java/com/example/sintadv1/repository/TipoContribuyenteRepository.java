package com.example.sintadv1.repository;

import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {

    Optional<TipoContribuyente> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
