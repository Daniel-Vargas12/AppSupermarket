package com.pruebatecnica.ejerciciosupermercado.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {

    private Long idProducto;
    private String nombreProd;
    private Integer cantProd;
    //detalles extra
    private Double precio;
    private Double subtotal;
    
}
