package com.example.sintadv1.service;

import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.repository.TipoDocumentoRepository;
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
public class TipoDocumentoTests {

    @Mock(lenient = true)
    private TipoDocumentoRepository tipoDocumentoRepository;

    @InjectMocks
    private TipoDocumentoServiceImpl tipoDocumentoService;

    private TipoDocumento tipoDocumento;

    @BeforeEach
    void setup(){
        tipoDocumento = new TipoDocumento("20", "test", "description", true);
    }

    @DisplayName("Test para guardar tipo documento")
    @Test
    void testSaveTipoDocumento(){

        given(tipoDocumentoRepository.findByCodigo(tipoDocumento.getCodigo()))
                .willReturn(Optional.empty());
        given(tipoDocumentoRepository.save(tipoDocumento)).willReturn(tipoDocumento);

        TipoDocumento tipoDocumento1 = tipoDocumentoService.saveTipoDocumento(tipoDocumento);

        assertThat(tipoDocumento1).isNotNull();
    }
}
