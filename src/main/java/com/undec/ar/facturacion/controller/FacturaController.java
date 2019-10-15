package com.undec.ar.facturacion.controller;


import com.undec.ar.facturacion.dto.FacturaDTO;
import com.undec.ar.facturacion.dto.Response;
import com.undec.ar.facturacion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/facturacion")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;


    @GetMapping
    public ResponseEntity<Response> list(){

        Response response = facturaService.findAll();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> findById(@PathVariable(value = "id") Integer id){

        Response response = facturaService.findOne(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody FacturaDTO facturaDTO){

        Response response = facturaService.save(facturaDTO);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@RequestBody FacturaDTO facturaDTO, @PathVariable Integer clienteId){

        Response response = facturaService.update(facturaDTO);

        return ResponseEntity.ok().body(response);
    }


}
