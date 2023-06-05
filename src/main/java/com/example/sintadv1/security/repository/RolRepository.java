package com.example.sintadv1.security.repository;

import com.example.sintadv1.security.entity.Rol;
import com.example.sintadv1.security.enums.RolEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolname(RolEnum rolname);
}
