package com.undec.ar.facturacion.service;

import com.undec.ar.facturacion.dto.FacturaDTO;
import com.undec.ar.facturacion.dto.Response;
import com.undec.ar.facturacion.model.Factura;
import com.undec.ar.facturacion.repository.ClienteRepository;
import com.undec.ar.facturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public Response findAll(){

        Response response = new Response();

        List<Factura> facturalist = facturaRepository.findAll();
        response.setData(facturalist);

        return  response;
    }


    public Response findOne(Integer id){

        Response response = new Response();
        Factura factura = facturaRepository.getOne(id);
        response.setData(factura);

        return response;
    }


    public Response delete(Integer id){

        Response response = new Response();
        facturaRepository.delete(facturaRepository.getOne(id));
        response.setMensaje("Eliminado");

        return response;
    }

    public Response update(FacturaDTO facturaDTO){

        Response response = new Response();
        Factura factura = facturaDTOToEntity(facturaDTO);
        facturaRepository.save(factura);
        response.setMensaje("OK");

        return response;
    }


    public Response save(FacturaDTO facturaDTO){

        Response response = new Response();
        Factura factura = facturaDTOToEntity(facturaDTO);
        response.setData(facturaRepository.save(factura));

        return response;
    }


    private Factura facturaDTOToEntity(FacturaDTO facturaDTO){

        Factura factura = new Factura();
        factura.setId(facturaDTO.getId());
        factura.setDescripcion(facturaDTO.getDescripcion());
        factura.setObservacion(facturaDTO.getObservacion());
        factura.setFolio(facturaDTO.getFolio());
        factura.setFecha(new Date());
        factura.setClienteByClienteId(clienteRepository.getOne(facturaDTO.getClienteid()));


        return factura;
    }




}
