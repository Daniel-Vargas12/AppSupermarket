package com.pruebatecnica.ejerciciosupermercado.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;
import com.pruebatecnica.ejerciciosupermercado.service.IProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//controller->service->repository
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @GetMapping    
    public ResponseEntity<List<ProductoDTO>> traerProductos(){

        return ResponseEntity.ok(productoService.traerProductos());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO dto){
        ProductoDTO creado = productoService.crearProducto(dto);

        return ResponseEntity.created(URI.create("/api/productos" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, 
                                                            @RequestBody ProductoDTO dto){
          return ResponseEntity.ok(productoService.actualizarProducto(id, dto));                                                      
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);

        return ResponseEntity.noContent().build();
    }

}
