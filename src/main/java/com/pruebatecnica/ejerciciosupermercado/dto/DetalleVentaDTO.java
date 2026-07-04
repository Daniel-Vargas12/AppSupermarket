package com.pruebatecnica.ejerciciosupermercado.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "Debe indicar el producto")
    private Long idProducto;
    
    @NotNull(message = "Debe indicar la cantidad")
    @Positive(message = "La cantidad debe ser mayor a cero")
    private Integer cantProd;
    private String nombreProd;
    //detalles extra
    private Double precio;
    private Double subtotal;
    
}
