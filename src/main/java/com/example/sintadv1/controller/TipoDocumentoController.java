package com.example.sintadv1.controller;

import com.example.sintadv1.dto.TipoDocumentoDto;
import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.service.TipoDocumentoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sintad/tipo-documento")
@CrossOrigin("*")
public class TipoDocumentoController {

    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @GetMapping("/list")
    public ResponseEntity<List<TipoDocumento>> listTipoDocumento(){
        List<TipoDocumento> tipoDocumentos = tipoDocumentoService.getAllTipoDocumento();


        return new ResponseEntity(tipoDocumentos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoDocumentoDto tipoDocumentoDto){
        if(StringUtils.isBlank(tipoDocumentoDto.getCodigo()))
            return new ResponseEntity("El codigo es requerido", HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tipoDocumentoDto.getNombre()))
            return new ResponseEntity("El nombre es requerido", HttpStatus.BAD_REQUEST);

        TipoDocumento tipoDocumento = new TipoDocumento(tipoDocumentoDto.getCodigo(),
                tipoDocumentoDto.getNombre(),
                tipoDocumentoDto.getDescripcion(),
                tipoDocumentoDto.isEstado());
        tipoDocumentoService.saveTipoDocumento(tipoDocumento);
        return new ResponseEntity("Nuevo tipo de documento agregado", HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @RequestBody TipoDocumentoDto tipoDocumentoDto, @PathVariable(value = "id") Long id
    ){
        if(!tipoDocumentoService.existsById(id))
            return new ResponseEntity("El tipo documento no existe", HttpStatus.NOT_FOUND);

        TipoDocumento tipoDocumento = tipoDocumentoService.findById(id);
        tipoDocumento.setCodigo(tipoDocumentoDto.getCodigo());
        tipoDocumento.setNombre(tipoDocumentoDto.getNombre());
        tipoDocumento.setDescripcion(tipoDocumentoDto.getDescripcion());
        tipoDocumento.setEstado(tipoDocumentoDto.isEstado());

        tipoDocumentoService.saveTipoDocumento(tipoDocumento);
        return new ResponseEntity("TipoDocumento actualizado", HttpStatus.OK);
    }
}
