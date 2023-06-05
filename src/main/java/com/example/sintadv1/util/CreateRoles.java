package com.example.sintadv1.util;

import com.example.sintadv1.security.entity.Rol;
import com.example.sintadv1.security.enums.RolEnum;
import com.example.sintadv1.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;



    @Override
    public void run(String... args) throws Exception {
        /*Rol rolAdmin = new Rol(RolEnum.ROLE_ADMIN);
        Rol rolUser = new Rol(RolEnum.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);*/
    }
}
