package com.pruebatecnica.ejerciciosupermercado.service;

import java.util.List;

import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;

public interface IProductoService {

    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO productoDto);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDto);
    void eliminarProducto(Long id);
    

}
