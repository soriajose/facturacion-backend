package com.undec.ar.facturacion.repository;

import com.undec.ar.facturacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
