package com.pruebatecnica.ejerciciosupermercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.ejerciciosupermercado.dto.ProductoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.ProductoVendidoDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaPorDiaDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaSucursalDTO;
import com.pruebatecnica.ejerciciosupermercado.service.IEstadisticaService;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {

    @Autowired
    private IEstadisticaService estadisticaService;

    @GetMapping("/cantidad-ventas")
    public Long cantidadVentas(){
        return estadisticaService.cantidadVentas();
    }

    @GetMapping("/ingreso-total")
    public Double ingresoTotal(){
        return estadisticaService.ingresoTotal();
    }

    @GetMapping("/stock-bajo")
    public List<ProductoDTO> stockBajo(){
        return estadisticaService.stockBajo();
    }

    @GetMapping("/ventas-por-dia")
    public List<VentaPorDiaDTO> ventasPorDia(){
        return estadisticaService.ventasPorDia();
    }

    @GetMapping("/ventas-por-sucursal")
    public List<VentaSucursalDTO> ventasPorSucursal(){
        return estadisticaService.ventasPorSucursal();
    }

    @GetMapping("/producto-mas-vendido")
    public ProductoVendidoDTO productoMasVendido(){
        return estadisticaService.productoMasVendido();
    }

    @GetMapping("/top5-productos")
    public List<ProductoVendidoDTO> top5Productos(){
        return estadisticaService.top5Productos();
    }
}