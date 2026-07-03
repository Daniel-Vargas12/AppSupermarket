package com.pruebatecnica.ejerciciosupermercado.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    
    //venta
    @ManyToOne (fetch = FetchType.LAZY)//varios detalles pueden estar asociados a una venta
    @JoinColumn(name="ventaId")
    private Venta venta;

    //producto
    @ManyToOne (fetch = FetchType.LAZY)//varios detalles pueden contener un mismo producto
    @JoinColumn(name = "productoId")
    private Producto prod;
    private String nombreProd;
    private Integer cantProd;
    private Double precio;
    private Double subtotal;

}
