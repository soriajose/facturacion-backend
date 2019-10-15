package com.undec.ar.facturacion.service;

import com.undec.ar.facturacion.dto.Response;
import com.undec.ar.facturacion.model.Cliente;
import com.undec.ar.facturacion.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Response findAll(){

        Response response = new Response();

        List<Cliente> clienteList = clienteRepository.findAll();

        response.setData(clienteList);

        return response;

    }

    public Response findOne(Integer id){

        Response response = new Response();

        Cliente cliente = clienteRepository.findById(id).get();

        response.setData(cliente);

        return response;
    }

    public Response save(Cliente cliente){

        Response response = new Response();

        response.setData(clienteRepository.save(cliente));

        return response;
    }

    public Response update(Cliente input){

        Response response = new Response();

        clienteRepository.save(input);

        response.setMensaje("OK");

        return response;
    }

    public Response delete(Integer id){

        Response response = new Response();

        clienteRepository.delete(clienteRepository.getOne(id));

        response.setMensaje("Eliminado");

        return response;
    }


}
