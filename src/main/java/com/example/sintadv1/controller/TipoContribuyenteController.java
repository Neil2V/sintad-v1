package com.example.sintadv1.controller;

import com.example.sintadv1.dto.TipoContribuyenteDto;
import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.service.TipoContribuyenteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sintad/tipo-contribuyente")
@CrossOrigin("*")
public class TipoContribuyenteController {

    @Autowired
    TipoContribuyenteService tipoContribuyenteService;

    @GetMapping("/list")
    public ResponseEntity<List<TipoContribuyente>> list(){
        List<TipoContribuyente> tipoContribuyentes = tipoContribuyenteService.getAllTipoContribuyente();
        return new ResponseEntity(tipoContribuyentes, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoContribuyenteDto tipoContribuyenteDto){
        if(StringUtils.isBlank(tipoContribuyenteDto.getNombre()))
            return new ResponseEntity("El nombre es requerido", HttpStatus.BAD_REQUEST);

        TipoContribuyente tipoContribuyente = new TipoContribuyente(tipoContribuyenteDto.getNombre(), tipoContribuyenteDto.isEstado());
        tipoContribuyenteService.saveTipoContribuyente(tipoContribuyente);
        return new ResponseEntity("Nuevo tipo de contribuyente agregado", HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @RequestBody TipoContribuyenteDto tipoContribuyenteDto, @PathVariable(value = "id") Long id
    ){
        if(!tipoContribuyenteService.existsById(id))
            return new ResponseEntity("El tipo contribuyente no existe", HttpStatus.NOT_FOUND);

        TipoContribuyente tipoContribuyente = tipoContribuyenteService.findById(id);
        tipoContribuyente.setNombre(tipoContribuyenteDto.getNombre());
        tipoContribuyente.setEstado(tipoContribuyenteDto.isEstado());

        tipoContribuyenteService.saveTipoContribuyente(tipoContribuyente);
        return new ResponseEntity("TipoContribuyente actualizado", HttpStatus.OK);
    }
}
