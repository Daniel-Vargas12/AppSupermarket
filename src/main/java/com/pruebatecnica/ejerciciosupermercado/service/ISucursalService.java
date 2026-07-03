package com.pruebatecnica.ejerciciosupermercado.service;

import java.util.List;

import com.pruebatecnica.ejerciciosupermercado.dto.SucursalDTO;

public interface ISucursalService {

    //crud de sucursales
    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursalDto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto);
    void eliminarSucursal(Long id);


}
