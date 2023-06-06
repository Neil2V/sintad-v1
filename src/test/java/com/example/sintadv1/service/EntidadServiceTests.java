package com.example.sintadv1.service;

import com.example.sintadv1.model.Entidad;
import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.repository.EntidadRepository;
import com.example.sintadv1.repository.TipoContribuyenteRepository;
import com.example.sintadv1.repository.TipoDocumentoRepository;
import com.example.sintadv1.service.impl.EntidadServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class EntidadServiceTests {

    @Mock
    private EntidadRepository entidadRepository;

    @Mock
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Mock
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @InjectMocks
    private EntidadServiceImpl entidadService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveEntidadTest() {

        Entidad entidad = new Entidad();
        entidad.setNro_documento("123456");
        entidad.setRazon_social("Razon social");
        entidad.setNombre_comercial("Nombre Comercial");
        entidad.setDireccion("Direccion");
        entidad.setTelefono("789456123");
        entidad.setEstado(true);

        // Configurar el comportamiento del repositorio de tipoDocumento
        TipoDocumento tipoDocumento = new TipoDocumento();
        when(tipoDocumentoRepository.findById(1L)).thenReturn(Optional.of(tipoDocumento));
        // Configurar el comportamiento del repositorio de tipoContribuyente
        TipoContribuyente tipoContribuyente = new TipoContribuyente();
        when(tipoContribuyenteRepository.findById(1L)).thenReturn(Optional.of(tipoContribuyente));

        // Ejecutar el método saveEntidad
        entidadService.saveEntidad(entidad);

        // Verificar que se haya llamado al método save del repositorio de Entidad
        verify(entidadRepository, times(1)).save(entidad);
    }
}
