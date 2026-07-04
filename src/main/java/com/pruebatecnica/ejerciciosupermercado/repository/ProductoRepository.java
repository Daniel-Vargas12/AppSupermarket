package com.pruebatecnica.ejerciciosupermercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.ejerciciosupermercado.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    // Productos con stock bajo
    List<Producto> findByCantidadLessThan(Integer cantidad);

}