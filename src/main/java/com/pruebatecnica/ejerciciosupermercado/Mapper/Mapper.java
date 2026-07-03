package com.pruebatecnica.ejerciciosupermercado.Mapper;

import java.util.stream.Collectors;

import com.pruebatecnica.ejerciciosupermercado.dto.DetalleVentaDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.SucursalDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaDTO;
import com.pruebatecnica.ejerciciosupermercado.model.Producto;
import com.pruebatecnica.ejerciciosupermercado.model.Sucursal;
import com.pruebatecnica.ejerciciosupermercado.model.Venta;

public class Mapper {


    //Mapeo de Producto a ProductoDTO
    public static ProductoDTO toDTO(Producto p){

        if(p==null) return null;
        
        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .cantidad(p.getCantidad())
                .build();
    }
    

    //Mapeo de Sucursal a SucursalDTO    
    public static SucursalDTO toDTO(Sucursal s){

        if(s==null) return null;
        
        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();
    }
    

    //Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta v){
        if(v==null) return null;

        var detalle = v.getDetalle().stream().map( det -> 
            DetalleVentaDTO.builder()
                .idProducto(det.getProd().getId())
                .nombreProd(det.getNombreProd())
                .cantProd(det.getCantProd())
                .precio(det.getPrecio())
                .subtotal(det.getSubtotal())
                .build()
        ).collect(Collectors.toList());

        return VentaDTO.builder()
            .id(v.getId())
            .fecha(v.getFecha())
            .idSucursal(v.getSucursal().getId())
            .estado(v.getEstado())
            .detalle(detalle)
            .total(v.getTotal())
            .build();
        
    }

}
