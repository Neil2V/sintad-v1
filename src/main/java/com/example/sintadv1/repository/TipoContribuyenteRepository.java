package com.example.sintadv1.repository;

import com.example.sintadv1.model.TipoContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {
}
