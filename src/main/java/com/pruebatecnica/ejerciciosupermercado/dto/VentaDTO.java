package com.pruebatecnica.ejerciciosupermercado.dto;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Debe indicar la fecha")
    private LocalDate fecha;
    @NotBlank(message = "Debe indicar el estado")
    private String estado;
    @NotNull(message = "Debe indicar la sucursal")
    private Long idSucursal;
    @NotEmpty(message = "La venta debe contener productos")
    @Valid
    private List<DetalleVentaDTO> detalle;

    private Double total;

    
}
