package com.prueba.tipocambio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionResponse {
    private double monto;
    private double montoFinal;
    private String monedaOrigen;
    private String monedaDestino;
    private double TipoCambio;


}
