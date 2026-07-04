package com.pruebatecnica.ejerciciosupermercado.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.ejerciciosupermercado.Mapper.Mapper;
import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.ProductoVendidoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaPorDiaDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaSucursalDTO;
import com.pruebatecnica.ejerciciosupermercado.repository.ProductoRepository;
import com.pruebatecnica.ejerciciosupermercado.repository.VentaRepository;

@Service
public class EstadisticaService implements IEstadisticaService {

    @Autowired
    private VentaRepository ventaRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Override
    public Long cantidadVentas() {
        return ventaRepo.count();
    }

    @Override
    public Double ingresoTotal() {
        return ventaRepo.obtenerIngresoTotal();
    }

    @Override
    public List<ProductoDTO> stockBajo() {
        return productoRepo.findByCantidadLessThan(5)
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public List<VentaPorDiaDTO> ventasPorDia() {
        return ventaRepo.obtenerVentasPorDia()
                .stream()
                .map(r -> new VentaPorDiaDTO(
                        (LocalDate) r[0],
                        (Double) r[1]
                ))
                .toList();
    }

    @Override
    public List<VentaSucursalDTO> ventasPorSucursal() {
        return ventaRepo.obtenerVentasPorSucursal()
                .stream()
                .map(r -> new VentaSucursalDTO(
                        (String) r[0],
                        (Double) r[1]
                ))
                .toList();
    }

    @Override
    public ProductoVendidoDTO productoMasVendido() {

        Object[] r = ventaRepo.obtenerProductosMasVendidos().get(0);

        return new ProductoVendidoDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        );
    }

    @Override
    public List<ProductoVendidoDTO> top5Productos() {

        return ventaRepo.obtenerProductosMasVendidos()
                .stream()
                .limit(5)
                .map(r -> new ProductoVendidoDTO(
                        (String) r[0],
                        ((Number) r[1]).longValue()
                ))
                .toList();
    }

}