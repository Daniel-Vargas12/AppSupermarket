package com.pruebatecnica.ejerciciosupermercado.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaPorDiaDTO {

    private LocalDate fecha;

    private Double total;

}