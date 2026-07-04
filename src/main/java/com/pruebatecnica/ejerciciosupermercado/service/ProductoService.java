package com.pruebatecnica.ejerciciosupermercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.ejerciciosupermercado.Mapper.Mapper;
import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;
import com.pruebatecnica.ejerciciosupermercado.exception.NotFoundException;
import com.pruebatecnica.ejerciciosupermercado.model.Producto;
import com.pruebatecnica.ejerciciosupermercado.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService{


    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoDTO> traerProductos(){

        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto){

        var prod = Producto.builder()
            .nombre(productoDto.getNombre())
            .categoria(productoDto.getCategoria())
            .precio(productoDto.getPrecio())
            .cantidad(productoDto.getCantidad())
            .build();
        return Mapper.toDTO(repo.save(prod));

    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO ProductoDto){

        //buscamos si existe el producto
        Producto prod = repo.findById(id)
        .orElseThrow(() -> new NotFoundException("Producto no encontrado!!"));

        prod.setNombre(ProductoDto.getNombre());
        prod.setCategoria(ProductoDto.getCategoria());
        prod.setCantidad(ProductoDto.getCantidad());
        prod.setPrecio(ProductoDto.getPrecio());

        return Mapper.toDTO(repo.save(prod));

    }


    //borrado fisico
    @Override
    public void eliminarProducto(Long id){
        if(!repo.existsById(id)){
            throw new NotFoundException("Producto no encontrado para eliminar!!");
        }
        repo.deleteById(id);
    }

}
