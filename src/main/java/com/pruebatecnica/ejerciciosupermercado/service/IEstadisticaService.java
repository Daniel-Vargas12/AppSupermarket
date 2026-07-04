package com.pruebatecnica.ejerciciosupermercado.service;

import java.util.List;

import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.ProductoVendidoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaPorDiaDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaSucursalDTO;

public interface IEstadisticaService {

    Long cantidadVentas();

    Double ingresoTotal();

    List<ProductoDTO> stockBajo();

    List<VentaPorDiaDTO> ventasPorDia();

    List<VentaSucursalDTO> ventasPorSucursal();

    ProductoVendidoDTO productoMasVendido();

    List<ProductoVendidoDTO> top5Productos();

}