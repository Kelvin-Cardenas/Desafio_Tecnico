package com.prueba.tipocambio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;


}
