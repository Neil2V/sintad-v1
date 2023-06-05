package com.example.sintadv1.util;

import com.example.sintadv1.model.Entidad;
import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.repository.EntidadRepository;
import com.example.sintadv1.repository.TipoContribuyenteRepository;
import com.example.sintadv1.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Run implements CommandLineRunner {

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    TipoContribuyenteRepository tipoContribuyenteRepository;

    @Autowired
    EntidadRepository entidadRepository;

    @Override
    public void run(String... args) throws Exception {
        /*TipoDocumento tipoDocumento1 = new TipoDocumento("20", "test", "description", true);

        TipoContribuyente tipoContribuyente1 = new TipoContribuyente("TestD", true);

        Entidad entidad1 = new Entidad("212121212",
                "AVATAR SAC",
                "nombre comercial",
                "jiron rio ucayali",
                "987654321",
                true);


        entidad1.setTipoContribuyente(tipoContribuyente1);
        entidad1.setTipoDocumento(tipoDocumento1);

        entidadRepository.save(entidad1);

        tipoDocumentoRepository.save(tipoDocumento1);
        tipoContribuyenteRepository.save(tipoContribuyente1);*/



    }
}
