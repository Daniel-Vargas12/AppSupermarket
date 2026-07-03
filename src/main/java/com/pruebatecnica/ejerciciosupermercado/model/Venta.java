package com.pruebatecnica.ejerciciosupermercado.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate fecha;
    private String estado;
    private Double total;
    @ManyToOne //MAPEO PARA JPA
    private Sucursal sucursal;  //RELACION UNOS A MUCHOS

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL,
        orphanRemoval = true, //Si hay hijos sueltos de una clase padre se tocan automaticamente
        fetch = FetchType.EAGER//forzar traer el detalle siempre
    )
    private List<DetalleVenta> detalle = new ArrayList<>();

    

}
