package com.pruebatecnica.ejerciciosupermercado.dto;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//EL DTO NO TRAE OBJETOS VENTA,PRODUCTO O SUCURSAL COMO EN LA CLASE VENTA, SINO QUE SE OPTIMIZA
//PARA TRAER SOLO EL DATO NECESARIO PARA LA BUSQUEDA
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaDTO {
    //@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate fecha;
    private String estado;

    private Long idSucursal;

    private List<DetalleVentaDTO> detalle;

    private Double total;

    
}
