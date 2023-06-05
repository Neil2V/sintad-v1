package com.example.sintadv1.controller;

import com.example.sintadv1.dto.EntidadDto;
import com.example.sintadv1.model.Entidad;
import com.example.sintadv1.model.TipoContribuyente;
import com.example.sintadv1.model.TipoDocumento;
import com.example.sintadv1.service.EntidadService;
import com.example.sintadv1.service.TipoContribuyenteService;
import com.example.sintadv1.service.TipoDocumentoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sintad/entidad")
@CrossOrigin("*")
public class EntidadController {

    @Autowired
    EntidadService entidadService;

    @Autowired
    TipoContribuyenteService tipoContribuyenteService;

    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @GetMapping("/list")
    public ResponseEntity<List<Entidad>> list(){
        List<Entidad> entidads = entidadService.getAllEntidades();
        return new ResponseEntity(entidads, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EntidadDto entidadDto){
        if(StringUtils.isBlank(entidadDto.getNro_documento()))
            return new ResponseEntity("El Numero de documento es requerido", HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(entidadDto.getRazon_social()))
            return new ResponseEntity("La razon social es requerido", HttpStatus.BAD_REQUEST);
        if(entidadDto.getId_tipo_documento()==null)
            return new ResponseEntity("La entidad debe estar asociada a un tipo de documento", HttpStatus.BAD_REQUEST);
        if(entidadDto.getId_tipo_contribuyente() !=null && !tipoContribuyenteService.existsById(entidadDto.getId_tipo_contribuyente()))
            return new ResponseEntity("No existe un tipo de contribuyente con el Id: "+entidadDto.getId_tipo_contribuyente(), HttpStatus.NOT_FOUND);
        if(!tipoDocumentoService.existsById(entidadDto.getId_tipo_documento()))
            return new ResponseEntity("No existe un tipo de documento con el Id: "+entidadDto.getId_tipo_documento(), HttpStatus.NOT_FOUND);

        Entidad entidad = new Entidad(entidadDto.getNro_documento(),
                entidadDto.getRazon_social(),
                entidadDto.getNombre_comercial(),
                entidadDto.getDireccion(),
                entidadDto.getTelefono(),
                entidadDto.isEstado());

        if(entidadDto.getId_tipo_contribuyente()!=null){
            TipoContribuyente tipoContribuyente = tipoContribuyenteService.findById(entidadDto.getId_tipo_contribuyente());
            entidad.setTipoContribuyente(tipoContribuyente);
        }

        TipoDocumento tipoDocumento = tipoDocumentoService.findById(entidadDto.getId_tipo_documento());
        entidad.setTipoDocumento(tipoDocumento);

        entidadService.saveEntidad(entidad);

        return new ResponseEntity("Entidad registrada", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody EntidadDto entidadDto, @PathVariable(value = "id") Long id){

        if(!entidadService.existsById(id))
            return new ResponseEntity("La entidad no fue encontrada en la base de datos", HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(entidadDto.getNro_documento()))
            return new ResponseEntity("El Numero de documento es requerido", HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(entidadDto.getRazon_social()))
            return new ResponseEntity("La razon social es requerido", HttpStatus.BAD_REQUEST);
        if(entidadDto.getId_tipo_documento()==null)
            return new ResponseEntity("La entidad debe estar asociada a un tipo de documento", HttpStatus.BAD_REQUEST);
        if(entidadDto.getId_tipo_contribuyente() !=null && !tipoContribuyenteService.existsById(entidadDto.getId_tipo_contribuyente()))
            return new ResponseEntity("No existe un tipo de contribuyente con el Id: "+entidadDto.getId_tipo_contribuyente(), HttpStatus.NOT_FOUND);
        if(!tipoDocumentoService.existsById(entidadDto.getId_tipo_documento()))
            return new ResponseEntity("No existe un tipo de documento con el Id: "+entidadDto.getId_tipo_documento(), HttpStatus.NOT_FOUND);

        Entidad entidad = entidadService.findById(id);
        entidad.setNro_documento(entidadDto.getNro_documento());
        entidad.setRazon_social(entidadDto.getRazon_social());
        entidad.setNombre_comercial(entidadDto.getNombre_comercial());
        entidad.setDireccion(entidadDto.getDireccion());
        entidad.setTelefono(entidadDto.getTelefono());
        entidad.setEstado(entidadDto.isEstado());

        if(entidadDto.getId_tipo_contribuyente()!=null){
            TipoContribuyente tipoContribuyente = tipoContribuyenteService.findById(entidadDto.getId_tipo_contribuyente());
            entidad.setTipoContribuyente(tipoContribuyente);
        }

        TipoDocumento tipoDocumento = tipoDocumentoService.findById(entidadDto.getId_tipo_documento());
        entidad.setTipoDocumento(tipoDocumento);

        entidadService.saveEntidad(entidad);

        return new ResponseEntity("Entidad actualizada", HttpStatus.OK);
    }
}
