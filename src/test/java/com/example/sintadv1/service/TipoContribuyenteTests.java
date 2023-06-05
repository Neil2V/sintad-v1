package com.example.sintadv1.service;

import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.repository.TipoContribuyenteRepository;
import com.example.sintadv1.repository.TipoDocumentoRepository;
import com.example.sintadv1.service.impl.TipoContribuyenteServiceImpl;
import com.example.sintadv1.service.impl.TipoDocumentoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TipoContribuyenteTests {

    @Mock(lenient = true)
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @InjectMocks
    private TipoContribuyenteServiceImpl tipoContribuyenteService;

    private TipoContribuyente tipoContribuyente;

    @BeforeEach
    void setup(){
        tipoContribuyente = new TipoContribuyente("TestD", true);
    }

    @DisplayName("Test para guardar tipo contribuyente")
    @Test
    void testSaveTipoDocumento(){

        given(tipoContribuyenteRepository.findByNombre(tipoContribuyente.getNombre()))
                .willReturn(Optional.empty());
        given(tipoContribuyenteRepository.save(tipoContribuyente)).willReturn(tipoContribuyente);

        TipoContribuyente tipoContribuyente1 = tipoContribuyenteService.saveTipoContribuyente(tipoContribuyente);

        assertThat(tipoContribuyente1).isNotNull();
    }
}
