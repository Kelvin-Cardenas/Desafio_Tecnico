package com.prueba.tipocambio.service;

import com.prueba.tipocambio.client.ExchangeClient;
import com.prueba.tipocambio.domain.model.ConversionRequest;
import com.prueba.tipocambio.domain.model.ConversionResponse;
import com.prueba.tipocambio.domain.model.ExchangeRateResponse;
import com.prueba.tipocambio.repository.ConversionRecord;
import com.prueba.tipocambio.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ConversionService {
    private final ExchangeClient exchangeClient;
    private final ConversionRepository conversionRepository;

    @Autowired
    public ConversionService(ExchangeClient exchangeClient, ConversionRepository conversionRepository) {
        this.exchangeClient = exchangeClient;
        this.conversionRepository = conversionRepository;
    }

    public ConversionResponse applyConversion(ConversionRequest request) {
        // Obtenemos los tipos de cambio
        ExchangeRateResponse exchangeRate = exchangeClient.getExchangeRates();

        // verificamos si  se obtuvo correctamente el tipo de cambio para la moneda de origen
        if (exchangeRate == null || exchangeRate.getRates() == null) {
            throw new RuntimeException("Failed to retrieve exchange rates for currency: " + request.getMonedaOrigen());
        }

        // verificamos si  se obtuvo correctamente el tipo de cambio para la moneda de destino
        Double targetRate = exchangeRate.getRates().get(request.getMonedaDestino());
        if (targetRate == null) {
            throw new RuntimeException("Failed to retrieve exchange rate for currency: " + request.getMonedaDestino());
        }

        // Calcular el monto convertido
        double convertedAmount = request.getMonto() * targetRate;

        // Guardar la conversión en la base de datos H2
        conversionRepository.save(request, convertedAmount, targetRate);

        // Crear y devolver la respuesta de conversión
        return new ConversionResponse(
                request.getMonto(),
                convertedAmount,
                request.getMonedaOrigen(),
                request.getMonedaDestino(),
                targetRate
        );
    }
}

