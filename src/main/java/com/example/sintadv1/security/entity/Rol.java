package com.example.sintadv1.security.entity;

import com.example.sintadv1.security.enums.RolEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "tb_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RolEnum rolname;

    public Rol() {
    }

    public Rol(@NotNull RolEnum rolname) {
        this.rolname = rolname;
    }
}
