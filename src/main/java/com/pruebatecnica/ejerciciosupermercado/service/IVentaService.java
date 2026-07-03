package com.pruebatecnica.ejerciciosupermercado.service;

import java.util.List;

import com.pruebatecnica.ejerciciosupermercado.dto.VentaDTO;

public interface IVentaService {

    List<VentaDTO> traerVentas();
    VentaDTO crearVenta(VentaDTO ventaDto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaDto);
    void eliminarVenta(Long id);

}
