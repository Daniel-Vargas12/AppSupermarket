package com.pruebatecnica.ejerciciosupermercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebatecnica.ejerciciosupermercado.model.Venta;

public interface VentaRepository extends JpaRepository <Venta, Long>{

    @Query("""
        SELECT v.fecha, SUM(v.total)
        FROM Venta v
        GROUP BY v.fecha
        ORDER BY v.fecha
        """)
        List<Object[]> obtenerVentasPorDia();
    

    @Query("""
        SELECT v.sucursal.nombre, SUM(v.total)
        FROM Venta v
        GROUP BY v.sucursal.nombre
        ORDER BY SUM(v.total) DESC
        """)
        List<Object[]> obtenerVentasPorSucursal();

    @Query("""
        SELECT SUM(v.total)
        FROM Venta v
        """)
        Double obtenerIngresoTotal();

    @Query("""
        SELECT
            d.prod.nombre,
            SUM(d.cantProd)
        FROM DetalleVenta d
        GROUP BY d.prod.nombre
        ORDER BY SUM(d.cantProd) DESC
        """)
        List<Object[]> obtenerProductosMasVendidos();

} 
