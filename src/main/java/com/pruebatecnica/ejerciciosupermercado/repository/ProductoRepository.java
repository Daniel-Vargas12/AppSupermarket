package com.pruebatecnica.ejerciciosupermercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.ejerciciosupermercado.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    //Buscar producto x nombre
    Optional<Producto> findByNombre(String nombre);
    
} 
