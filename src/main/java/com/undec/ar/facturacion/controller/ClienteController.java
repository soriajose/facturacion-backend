package com.undec.ar.facturacion.controller;

import com.undec.ar.facturacion.dto.Response;
import com.undec.ar.facturacion.model.Cliente;
import com.undec.ar.facturacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Response> list(){

        Response response = clienteService.findAll();

        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }


    @GetMapping("{/id}")
    public ResponseEntity<Response> findById(@PathVariable("/id") Integer clienteId){

        Response response = clienteService.findOne(clienteId);

        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody Cliente cliente){

        Response response = clienteService.save(cliente);

        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Valid @RequestBody Cliente cliente, @PathVariable Integer id){

        Response response = clienteService.update(cliente);

        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

}
